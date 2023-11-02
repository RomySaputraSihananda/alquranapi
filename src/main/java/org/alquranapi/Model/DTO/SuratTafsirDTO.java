package org.alquranapi.Model.DTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.alquranapi.Model.DAO.SuratDAO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SuratTafsirDTO extends SuratDTO {
    private ArrayList<TafsirDTO> tafsir;
    private SuratPrevNextDTO suratSelanjutnya;
    private SuratPrevNextDTO suratSebelumnya;

    public SuratTafsirDTO(SuratDAO surat) {
        super(surat);
        this.tafsir = new ArrayList<>(
                surat.getAyat().stream().map(e -> new TafsirDTO(e.getTafsir())).collect(Collectors.toList()));
        this.suratSelanjutnya = check(surat.getNomorSuratSelanjutnya());
        this.suratSebelumnya = check(surat.getNomorSuratSebelumnya());
    }

    private SuratPrevNextDTO check(SuratDAO surat) {
        return surat != null ? new SuratPrevNextDTO(surat) : null;
    }
}
