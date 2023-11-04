package org.alquranapi.Model.DTO;

import java.util.Map;

import lombok.Data;

@Data
public class AyatDTO {
    private int nomorAyat;
    private String teksArab;
    private String teksLatin;
    private String teksIndonesia;
    private Map<String, String> audio;
}
