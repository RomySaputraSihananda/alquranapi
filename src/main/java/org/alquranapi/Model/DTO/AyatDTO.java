package org.alquranapi.Model.DTO;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.alquranapi.Model.DAO.AyatDAO;

import lombok.Data;

@Data
public class AyatDTO {
    private int nomorAyat;
    private String teksArab;
    private String teksLatin;
    private String teksIndonesia;
    private Map<?, ?> audio;

    public AyatDTO(AyatDAO ayat) {
        this.nomorAyat = ayat.getNomorAyat();
        this.teksArab = ayat.getTeksArab();
        this.teksLatin = ayat.getTeksLatin();
        this.teksIndonesia = ayat.getTeksIndonesia();
        this.audio = IntStream.range(0, ayat.getAudio().size())
                .boxed()
                .collect(Collectors.toMap(
                        index -> String.format("0%d", index + 1),
                        index -> ayat.getAudio().get(index).getAudioLink()));
    }
}
