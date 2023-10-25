package org.alquranapi.service;

import org.alquranapi.Model.DTO.SuratDetailDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AlquranService {
    public SuratDetailDTO getDetail(int nomor) {
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
