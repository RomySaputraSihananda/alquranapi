package org.alquranapi.model.DTO;

import org.alquranapi.model.DAO.SuratDAO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SuratPrevNextDTO {
    private int nomor;
    private String nama;
    private String namaLatin;
    private int jumlahAyat;

    public SuratPrevNextDTO(SuratDAO surat) {
        this.nomor = surat.getNomor();
        this.nama = surat.getNama();
        this.namaLatin = surat.getNamaLatin();
        this.jumlahAyat = surat.getJumlahAyat();
    }
}
