package org.alquranapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.alquranapi.Model.DTO.SuratDTO;
import org.alquranapi.Model.DTO.SuratDetailDTO;
import org.alquranapi.Model.DTO.SuratTafsirDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

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

    public ArrayList<SuratTafsirDTO> getTafsir(int nomor) {
        return new ArrayList<>(List.of(readFile("tafsir_alquran", nomor, SuratTafsirDTO.class)));
    }

    public Map<String, List<Integer>> getPerJuz(int nomor) {
        return readFile("juz_alquran", nomor, Map.class);
    }

    public <T> T readFile(String type, int nomor, Class<T> typeClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Resource resource = new ClassPathResource("data/" + type + "/" + nomor + ".json");
            T surat = (T) objectMapper.readValue(resource.getInputStream(), typeClass);
            return surat;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
