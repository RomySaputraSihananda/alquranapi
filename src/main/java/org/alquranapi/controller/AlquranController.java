package org.alquranapi.controller;

import org.alquranapi.service.AlquranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/alquran")
public class AlquranController {

    @Autowired
    private AlquranService alquranService;

    @GetMapping
    public ResponseEntity<?> handler(@RequestParam(name = "nomorSurat") int nomor) {
        return new ResponseEntity<>(this.alquranService.getDetail(nomor), HttpStatus.OK);
    }
}
