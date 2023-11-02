package org.alquranapi.Model.DTO;

import org.alquranapi.Model.DAO.TafsirDAO;

import lombok.Data;

@Data
public class TafsirDTO {
    private int ayat;
    private String teks;

    public TafsirDTO(TafsirDAO tafsir) {
        this.ayat = tafsir.getNomotAyat();
        this.teks = tafsir.getTeks();
    }
}
