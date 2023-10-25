package org.alquranapi.service;

import java.util.ArrayList;

import org.alquranapi.Model.DTO.SuratDTO;
import org.alquranapi.Model.DTO.SuratDetailDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AlquranService {
    public ArrayList<SuratDTO> getAll() {
        ArrayList<SuratDTO> allSurat = new ArrayList<>();
        for (int i = 1; i <= 114; i++) {
            allSurat.add(new SuratDTO(readFile(i)));
        }
        return allSurat;
    }

    public SuratDetailDTO getDetail(int nomor) {
        return readFile(nomor);
    }

    public SuratDetailDTO readFile(int nomor) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Resource resource = new ClassPathResource("data/surat_alquran/" + nomor + ".json");
            SuratDetailDTO surat = objectMapper.readValue(resource.getInputStream(), SuratDetailDTO.class);
            return surat;
        } catch (Exception e) {
            return null;
        }
    }
}
