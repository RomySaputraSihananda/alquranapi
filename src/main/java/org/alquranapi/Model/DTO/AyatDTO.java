package org.alquranapi.Model.DTO;

import java.util.Map;

import lombok.Data;

@Data
public class AyatDTO {
    private String nomorAyat;
    private String teksArab;
    private String teksLatin;
    private String teksIndonesia;
    private Map<String, String> audio;
}
