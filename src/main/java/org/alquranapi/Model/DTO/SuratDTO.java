package org.alquranapi.Model.DTO;

import java.util.Map;

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

    public SuratDTO(SuratDetailDTO suratDetailDTO) {
        super(suratDetailDTO);
        this.tempatTurun = suratDetailDTO.getTempatTurun();
        this.arti = suratDetailDTO.getArti();
        this.deskripsi = suratDetailDTO.getDeskripsi();
        this.audioFull = suratDetailDTO.getAudioFull();
    }
}
