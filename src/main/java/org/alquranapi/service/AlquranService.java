package org.alquranapi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.alquranapi.Model.DAO.SuratDAO;
import org.alquranapi.Model.DTO.SuratDTO;
import org.alquranapi.Model.DTO.SuratDetailDTO;
import org.alquranapi.Model.DTO.SuratTafsirDTO;
import org.alquranapi.exception.AlquranException;
import org.alquranapi.repository.SuratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AlquranService {
    @Autowired
    private SuratRepository alquranRepository;

    public ArrayList<SuratDTO> getAll() {
        return new ArrayList<>(this.alquranRepository.findAll().stream().map(surat -> new SuratDTO(surat))
                .collect(Collectors.toList()));
    }

    public ArrayList<SuratDetailDTO> getDetail(int nomor) {
        SuratDAO surat = this.alquranRepository.getByNomor(nomor);

        if (surat == null)
            throw new AlquranException("surat not found");

        return new ArrayList<>(List.of(surat).stream().map(e -> new SuratDetailDTO(e))
                .collect(Collectors.toList()));
    }

    public ArrayList<SuratDetailDTO> getAyat(int nomor) {
        return new ArrayList<>(List.of(readFile("surat_alquran", nomor, SuratDetailDTO.class)));
    }

    public ArrayList<SuratTafsirDTO> getTafsir(int nomor) {
        return new ArrayList<>(List.of(readFile("tafsir_alquran", nomor, SuratTafsirDTO.class)));
    }

    public <T> T readFile(String type, int nomor, Class<T> typeClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                true);
        try {
            Resource resource = new ClassPathResource("data/" + type + "/" + nomor + ".json");
            T surat = (T) objectMapper.readValue(resource.getInputStream(), typeClass);
            return surat;
        } catch (IOException e) {
            throw new AlquranException("surat not found");
        }
    }
}
