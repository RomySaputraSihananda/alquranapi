package org.alquranapi.model.DAO;

import java.util.ArrayList;

import org.alquranapi.model.DTO.AyatDTO;
import org.alquranapi.model.DTO.SuratDTO;
import org.alquranapi.model.DTO.SuratPrevNextDTO;
import org.alquranapi.model.DTO.TafsirDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SuratDAO extends SuratDTO {
    private ArrayList<AyatDTO> ayat;
    private ArrayList<TafsirDTO> tafsir;
    private SuratPrevNextDTO suratSelanjutnya;
    private SuratPrevNextDTO suratSebelumnya;
}
