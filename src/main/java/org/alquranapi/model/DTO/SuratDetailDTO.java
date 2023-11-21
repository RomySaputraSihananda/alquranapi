package org.alquranapi.model.DTO;

import java.util.ArrayList;

import org.alquranapi.model.DAO.SuratDAO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SuratDetailDTO extends SuratDTO {
    private ArrayList<AyatDTO> ayat;
    private SuratPrevNextDTO suratSelanjutnya;
    private SuratPrevNextDTO suratSebelumnya;

    public SuratDetailDTO(SuratDAO suratDAO) {
        super(suratDAO);
        this.ayat = suratDAO.getAyat();
        this.suratSelanjutnya = suratDAO.getSuratSelanjutnya();
        this.suratSebelumnya = suratDAO.getSuratSebelumnya();
    }
}
