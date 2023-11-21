package org.alquranapi.controller;

import java.io.IOException;

import org.alquranapi.model.DTO.SuratDTO;
import org.alquranapi.model.DTO.SuratDetailDTO;
import org.alquranapi.model.DTO.SuratPrevNextDTO;
import org.alquranapi.model.DTO.SuratTafsirDTO;
import org.alquranapi.payload.hit.ElasticHit;
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
        public ResponseEntity<BodyResponse<ElasticHit<SuratDTO>>> handlerGetAll() throws IOException {
                return new ResponseEntity<>(new BodyResponse<>("ok", HttpStatus.OK.value(), "all data surat Al-Quran",
                                this.alquranService.getAll()), HttpStatus.OK);
        }

        @Operation(summary = "Get detail surat", description = "API for get detail surat")
        @GetMapping("/{nomorSurat}")
        public ResponseEntity<BodyResponse<ElasticHit<SuratDetailDTO>>> handlerGetDetail(@PathVariable int nomorSurat)
                        throws IOException {
                return new ResponseEntity<>(
                                new BodyResponse<>("ok", HttpStatus.OK.value(),
                                                "all detail surat Al-Quran nomor " + nomorSurat,
                                                this.alquranService.getDetail(nomorSurat)),
                                HttpStatus.OK);
        }

        @Operation(summary = "Get tafsir surat", description = "API for get tafsir surat")
        @GetMapping("/tafsir/{nomorSurat}")
        public ResponseEntity<BodyResponse<ElasticHit<SuratTafsirDTO>>> handlerGetTafsir(@PathVariable int nomorSurat)
                        throws IOException {
                return new ResponseEntity<>(
                                new BodyResponse<>("ok", HttpStatus.OK.value(),
                                                "all tafsir surat Al-Quran nomor " + nomorSurat,
                                                this.alquranService.getTafsir(nomorSurat)),
                                HttpStatus.OK);
        }

        @Operation(summary = "Search by name surat", description = "API for search by name surat")
        @GetMapping("/search/nama/{namaSurat}")
        public ResponseEntity<BodyResponse<ElasticHit<SuratPrevNextDTO>>> handlerSearchByname(
                        @PathVariable String namaSurat)
                        throws IOException {
                return new ResponseEntity<>(
                                new BodyResponse<>("ok", HttpStatus.OK.value(),
                                                "all result searches name for key " + namaSurat,
                                                this.alquranService.searchByName(namaSurat)),
                                HttpStatus.OK);
        }

        @Operation(summary = "Search by name surat", description = "API for search by name surat")
        @GetMapping("/search/tempatTurun/{tempatTurun}")
        public ResponseEntity<BodyResponse<ElasticHit<SuratPrevNextDTO>>> handlerSearchByTempatTurun(
                        @PathVariable String tempatTurun)
                        throws IOException {
                return new ResponseEntity<>(
                                new BodyResponse<>("ok", HttpStatus.OK.value(),
                                                "all result searches tempat Turun for key " + tempatTurun,
                                                this.alquranService.searchByTempatTurun(tempatTurun)),
                                HttpStatus.OK);
        }
}
