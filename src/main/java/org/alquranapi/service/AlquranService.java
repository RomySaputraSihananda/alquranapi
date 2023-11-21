package org.alquranapi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.alquranapi.exception.AlquranException;
import org.alquranapi.model.DAO.SuratDAO;
import org.alquranapi.model.DTO.SuratDTO;
import org.alquranapi.model.DTO.SuratDetailDTO;
import org.alquranapi.model.DTO.SuratPrevNextDTO;
import org.alquranapi.model.DTO.SuratTafsirDTO;
import org.alquranapi.payload.hit.ElasticHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;

@Service
public class AlquranService {
        @Autowired
        private ElasticsearchClient client;

        @Value("${service.elastic.index}")
        private String index;

        public ArrayList<ElasticHit<SuratDTO>> getAll() throws IOException {
                SearchResponse<SuratDAO> response = this.client.search(search -> search.index(this.index).size(114),
                                SuratDAO.class);

                return new ArrayList<>(response.hits().hits().stream()
                                .map(surat -> new ElasticHit<SuratDTO>(surat.id(), surat.index(),
                                                new SuratDTO(surat.source())))
                                .collect(Collectors.toList()));
        }

        public ArrayList<ElasticHit<SuratDetailDTO>> getDetail(int nomor) throws IOException {
                GetResponse<SuratDAO> response = this.client.get(
                                get -> get.index(this.index).id(Integer.toString(nomor)),
                                SuratDAO.class);
                if (!response.found())
                        throw new AlquranException("surat not found");

                return new ArrayList<>(List.of(new ElasticHit<SuratDetailDTO>(response.id(), response.index(),
                                new SuratDetailDTO(response.source()))));
        }

        public ArrayList<ElasticHit<SuratTafsirDTO>> getTafsir(int nomor) throws IOException {
                GetResponse<SuratDAO> response = this.client.get(
                                get -> get.index(this.index).id(Integer.toString(nomor)),
                                SuratDAO.class);
                if (!response.found())
                        throw new AlquranException("surat not found");

                return new ArrayList<>(List.of(
                                new ElasticHit<SuratTafsirDTO>(response.id(), response.index(),
                                                new SuratTafsirDTO(response.source()))));
        }

        public ArrayList<ElasticHit<SuratPrevNextDTO>> searchByName(String value) throws IOException {
                return this.search("namaLatin", value);
        }

        public ArrayList<ElasticHit<SuratPrevNextDTO>> searchByTempatTurun(String value) throws IOException {
                return this.search("tempatTurun", value);
        }

        private ArrayList<ElasticHit<SuratPrevNextDTO>> search(String field, String value) throws IOException {
                SearchResponse<SuratDAO> response = this.client.search(search -> search
                                .index(this.index)
                                .query(query -> query
                                                .bool(bool -> bool
                                                                .must(must -> must
                                                                                .match(match -> match
                                                                                                .field(field)
                                                                                                .query(value)))))
                                .size(114),
                                SuratDAO.class);

                if (response.hits().maxScore().isNaN())
                        throw new AlquranException("surat not found");

                return new ArrayList<>(response.hits().hits().stream()
                                .map(surat -> new ElasticHit<SuratPrevNextDTO>(surat.id(), surat.index(),
                                                new SuratPrevNextDTO(surat.source())))
                                .collect(Collectors.toList()));
        }
}
