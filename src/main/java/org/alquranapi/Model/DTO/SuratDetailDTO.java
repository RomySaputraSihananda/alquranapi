package org.alquranapi.Model.DTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.alquranapi.Model.DAO.SuratDAO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SuratDetailDTO extends SuratDTO {
    private ArrayList<AyatDTO> ayat;
    private SuratPrevNextDTO suratSelanjutnya;
    private SuratPrevNextDTO suratSebelumnya;

    public SuratDetailDTO(SuratDAO surat) {
        super(surat);
        this.ayat = new ArrayList<>(
                surat.getAyat().stream().map(ayat -> new AyatDTO(ayat)).collect(Collectors.toList()));
        this.suratSelanjutnya = check(surat.getNomorSuratSelanjutnya());
        this.suratSebelumnya = check(surat.getNomorSuratSebelumnya());
    }

    private SuratPrevNextDTO check(SuratDAO surat) {
        return surat != null ? new SuratPrevNextDTO(surat) : null;
    }
}
