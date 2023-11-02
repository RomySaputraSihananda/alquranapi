package org.alquranapi.controller;

import org.alquranapi.Model.DTO.SuratDTO;
import org.alquranapi.Model.DTO.SuratDetailDTO;
import org.alquranapi.Model.DTO.SuratTafsirDTO;
import org.alquranapi.payload.response.BodyResponse;
import org.alquranapi.service.AlquranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/alquran")
public class AlquranController {
        @Autowired
        private AlquranService alquranService;

        @Operation(summary = "Get all surat", description = "API for get all surat")
        @GetMapping
        public ResponseEntity<BodyResponse<?>> handlerGetAll() {
                return new ResponseEntity<>(new BodyResponse<>("ok", HttpStatus.OK.value(), "all data surat Al-Quran",
                                this.alquranService.getAll()), HttpStatus.OK);
        }

        @Operation(summary = "Get detail surat", description = "API for get detail surat")
        @GetMapping("/{nomorSurat}")
        public ResponseEntity<BodyResponse<?>> handlerGetDetail(@PathVariable Long nomorSurat) {
                return new ResponseEntity<>(
                                new BodyResponse<>("ok", HttpStatus.OK.value(),
                                                "all detail surat Al-Quran nomor " + nomorSurat,
                                                this.alquranService.getDetail(nomorSurat)),
                                HttpStatus.OK);
        }

        @Operation(summary = "Get tafsir surat", description = "API for get tafsir surat")
        @GetMapping("/tafsir/{nomorSurat}")
        public ResponseEntity<BodyResponse<SuratTafsirDTO>> handlerGetTafsir(@PathVariable int nomorSurat) {
                return new ResponseEntity<>(
                                new BodyResponse<>("ok", HttpStatus.OK.value(),
                                                "all tafsir surat Al-Quran nomor " + nomorSurat,
                                                this.alquranService.getTafsir(nomorSurat)),
                                HttpStatus.OK);
        }
}
