package org.alquranapi.Model.DTO;

import java.util.Map;

import lombok.Data;

@Data
public class SuratDTO {
    private int nomor;
    private String nama;
    private String namaLatin;
    private int jumlahAyat;
    private String tempatTurun;
    private String arti;
    private Map<String, AyatDTO> ayat;
}
