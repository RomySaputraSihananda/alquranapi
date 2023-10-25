package org.alquranapi.Model.DTO;

import java.util.ArrayList;
import java.util.Map;

import lombok.Data;

@Data
public class SuratDetailDTO extends SuratDTO {
    private String tempatTurun;
    private String arti;
    private String deskripsi;
    private Map<String, String> audioFull;
    private ArrayList<AyatDTO> ayat;
    private SuratDTO suratSelanjutnya;
    private SuratDTO suratSebelumnya;
}
