package org.alquranapi.controller;

import org.alquranapi.Model.DTO.SuratDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/alquran")
public class alquranController {
    @GetMapping
    public SuratDTO handler(@RequestParam(name = "surat") int suratParam) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Resource resource = new ClassPathResource("data/surat_alquran/" + suratParam + ".json");
            SuratDTO surat = objectMapper.readValue(resource.getInputStream(), SuratDTO.class);
            return surat;
        } catch (Exception e) {
            return null;
        }
    }
}
