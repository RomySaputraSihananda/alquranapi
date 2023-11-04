package org.alquranapi.Model.DTO;

import java.util.Map;

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

    public SuratDTO(SuratDAO suratDAO) {
        super(suratDAO);
        this.tempatTurun = suratDAO.getTempatTurun();
        this.arti = suratDAO.getArti();
        this.deskripsi = suratDAO.getDeskripsi();
        this.audioFull = suratDAO.getAudioFull();
    }
}
