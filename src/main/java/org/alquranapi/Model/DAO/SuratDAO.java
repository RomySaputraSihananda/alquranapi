package org.alquranapi.Model.DAO;

import java.util.ArrayList;

import org.alquranapi.Model.DTO.AyatDTO;
import org.alquranapi.Model.DTO.SuratDTO;
import org.alquranapi.Model.DTO.SuratPrevNextDTO;
import org.alquranapi.Model.DTO.TafsirDTO;

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
