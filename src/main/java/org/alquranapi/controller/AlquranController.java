package org.alquranapi.controller;

import org.alquranapi.Model.DTO.SuratDTO;
import org.alquranapi.Model.DTO.SuratDetailDTO;
import org.alquranapi.payload.response.BodyResponse;
import org.alquranapi.service.AlquranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/alquran")
public class AlquranController {
    @Autowired
    private AlquranService alquranService;

    @GetMapping
    public ResponseEntity<BodyResponse<SuratDTO>> handlerGetAll() {
        return new ResponseEntity<>(new BodyResponse<>("ok", HttpStatus.OK.value(), "all data surat Al-Quran",
                this.alquranService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{nomorSurat}")
    public ResponseEntity<BodyResponse<SuratDetailDTO>> handlerGetDetail(@PathVariable int nomorSurat) {
        return new ResponseEntity<>(
                new BodyResponse<>("ok", HttpStatus.OK.value(), "all detail surat Al-Quran nomor " + nomorSurat,
                        this.alquranService.getDetail(nomorSurat)),
                HttpStatus.OK);
    }

    @GetMapping("juz/{nomorJuz")
    public ResponseEntity<BodyResponse<SuratDetailDTO>> handlerGetPerJuz(@PathVariable int nomorJuz) {
        return new ResponseEntity<>(
                new BodyResponse<>("ok", HttpStatus.OK.value(), "all detail surat Al-Quran juz " + nomorJuz,
                        this.alquranService.getPerJuz(nomorJuz)),
                HttpStatus.OK);
    }
}
