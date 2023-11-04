package org.alquranapi.Model.DTO;

import java.util.ArrayList;

import org.alquranapi.Model.DAO.SuratDAO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SuratTafsirDTO extends SuratDTO {
    private ArrayList<TafsirDTO> tafsir;
    private SuratPrevNextDTO suratSelanjutnya;
    private SuratPrevNextDTO suratSebelumnya;

    public SuratTafsirDTO(SuratDAO suratDAO) {
        super(suratDAO);
        this.tafsir = suratDAO.getTafsir();
        this.suratSelanjutnya = suratDAO.getSuratSelanjutnya();
        this.suratSebelumnya = suratDAO.getSuratSebelumnya();
    }
}
