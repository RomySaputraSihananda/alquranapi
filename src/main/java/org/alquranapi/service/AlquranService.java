package org.alquranapi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.alquranapi.Model.DAO.SuratDAO;
import org.alquranapi.Model.DTO.SuratDTO;
import org.alquranapi.Model.DTO.SuratDetailDTO;
import org.alquranapi.Model.DTO.SuratPrevNextDTO;
import org.alquranapi.Model.DTO.SuratTafsirDTO;
import org.alquranapi.exception.AlquranException;

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

    public ArrayList<SuratDTO> getAll() throws IOException {
        SearchResponse<SuratDAO> response = this.client.search(search -> search.index(this.index).size(114),
                SuratDAO.class);

        return new ArrayList<>(response.hits().hits().stream().map(surat -> new SuratDTO(surat.source()))
                .collect(Collectors.toList()));
    }

    public ArrayList<SuratDetailDTO> getDetail(int nomor) throws IOException {
        GetResponse<SuratDAO> response = this.client.get(get -> get.index(this.index).id(Integer.toString(nomor)),
                SuratDAO.class);
        if (!response.found())
            throw new AlquranException("surat not found");

        return new ArrayList<>(List.of(new SuratDetailDTO(response.source())));
    }

    public ArrayList<SuratTafsirDTO> getTafsir(int nomor) throws IOException {
        GetResponse<SuratDAO> response = this.client.get(get -> get.index(this.index).id(Integer.toString(nomor)),
                SuratDAO.class);
        if (!response.found())
            throw new AlquranException("surat not found");

        return new ArrayList<>(List.of(new SuratTafsirDTO(response.source())));
    }

    public ArrayList<SuratPrevNextDTO> searchByName(String name) throws IOException {
        return this.search("namaLatin", name);
    }

    private ArrayList<SuratPrevNextDTO> search(String field, String value) throws IOException {
        SearchResponse<SuratDAO> response = this.client.search(search -> search
                .index(this.index)
                .query(query -> query
                        .bool(bool -> bool
                                .must(must -> must
                                        .match(match -> match
                                                .field(field)
                                                .query(value))))),
                SuratDAO.class);

        if (response.hits().maxScore().isNaN())
            throw new AlquranException("surat not found");

        return new ArrayList<>(response.hits().hits().stream().map(surat -> new SuratPrevNextDTO(surat.source()))
                .collect(Collectors.toList()));
    }
}
