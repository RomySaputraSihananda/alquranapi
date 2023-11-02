package org.alquranapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.alquranapi.Model.DAO.SuratDAO;
import org.alquranapi.Model.DTO.SuratDTO;
import org.alquranapi.Model.DTO.SuratDetailDTO;
import org.alquranapi.Model.DTO.SuratPrevNextDTO;
import org.alquranapi.Model.DTO.SuratTafsirDTO;
import org.alquranapi.exception.AlquranException;
import org.alquranapi.repository.SuratRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlquranService {
    @Autowired
    private SuratRepository alquranRepository;

    public ArrayList<SuratDTO> getAll() {
        return new ArrayList<>(this.alquranRepository.findAll().stream().map(e -> new SuratDTO(e))
                .collect(Collectors.toList()));
    }

    public ArrayList<SuratDetailDTO> getDetail(int nomor) {
        SuratDAO surat = this.alquranRepository.getByNomor(nomor);

        if (surat == null)
            throw new AlquranException("surat not found");

        return new ArrayList<>(List.of(new SuratDetailDTO(surat)));
    }

    public ArrayList<SuratTafsirDTO> getTafsir(int nomor) {
        SuratDAO surat = this.alquranRepository.getByNomor(nomor);

        if (surat == null)
            throw new AlquranException("surat not found");

        return new ArrayList<>(List.of(new SuratTafsirDTO(surat)));
    }

    public ArrayList<?> search(String nama) {
        List<SuratDAO> surat = this.alquranRepository.findByNamaLatinContaining(nama);

        if (surat == null || surat.size() < 1)
            throw new AlquranException("surat not found");

        return new ArrayList<>(surat.stream().map(e -> new SuratPrevNextDTO(e))
                .collect(Collectors.toList()));
    }
}
