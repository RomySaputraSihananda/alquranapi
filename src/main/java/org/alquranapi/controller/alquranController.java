package org.alquranapi.controller;

import org.alquranapi.Model.DTO.SuratDetailDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/alquran")
public class alquranController {
    @GetMapping
    public ResponseEntity<?> handler(@RequestParam(name = "nomorSurat") int nomor) {

    }
}
