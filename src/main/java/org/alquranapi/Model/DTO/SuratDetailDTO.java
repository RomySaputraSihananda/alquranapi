package org.alquranapi.Model.DTO;

import java.util.ArrayList;

import lombok.Data;

@Data
public class SuratDetailDTO extends SuratDTO {
    private ArrayList<AyatDTO> ayat;
    private SuratPrevNextDTO suratSelanjutnya;
    private SuratPrevNextDTO suratSebelumnya;
}
