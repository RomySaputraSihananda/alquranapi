package org.alquranapi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.alquranapi.Model.DTO.SuratDTO;
import org.alquranapi.Model.DTO.SuratDetailDTO;
import org.alquranapi.Model.DTO.SuratTafsirDTO;
import org.alquranapi.exception.AlquranException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AlquranService {
    public ArrayList<SuratDTO> getAll() {
        ArrayList<SuratDTO> allSurat = new ArrayList<>();
        for (int i = 1; i <= 114; i++) {
            allSurat.add(new SuratDTO(readFile("surat_alquran", i, SuratDetailDTO.class)));
        }
        return allSurat;
    }

    public ArrayList<SuratDetailDTO> getDetail(int nomor) {
        return new ArrayList<>(List.of(readFile("surat_alquran", nomor, SuratDetailDTO.class)));
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
