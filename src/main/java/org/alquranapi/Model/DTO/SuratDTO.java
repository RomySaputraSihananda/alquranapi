package org.alquranapi.Model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SuratDTO {
    private int nomor;
    private String nama;
    private String namaLatin;
    private int jumlahAyat;

    public SuratDTO(SuratDetailDTO suratDetailDTO) {
        this.nomor = suratDetailDTO.getNomor();
        this.nama = suratDetailDTO.getNama();
        this.namaLatin = suratDetailDTO.getNamaLatin();
        this.jumlahAyat = suratDetailDTO.getJumlahAyat();
    }
}
