package org.alquranapi.Model.DTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.alquranapi.Model.DAO.AudioDAO;
import org.alquranapi.Model.DAO.SuratDAO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SuratDTO extends SuratPrevNextDTO {
    private String tempatTurun;
    private String arti;
    private String deskripsi;
    private Map<String, String> audioFull;

    public SuratDTO(SuratDAO surat) {
        super(surat);
        this.tempatTurun = surat.getTempatTurun();
        this.arti = surat.getArti();
        this.deskripsi = surat.getDeskripsi();
        this.audioFull = IntStream.range(0, surat.getAudioFull().size())
                .boxed()
                .collect(Collectors.toMap(
                        index -> String.format("0%d", index + 1),
                        index -> surat.getAudioFull().get(index).getAudioLink()));
    }
}
