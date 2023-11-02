package org.alquranapi.Model.DAO;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "surat")
public class SuratDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nomor")
    private int nomor;

    @Column(name = "nama")
    private String nama;

    @Column(name = "nama_latin")
    private String namaLatin;

    @Column(name = "jumlah_ayat")
    private int jumlahAyat;

    @Column(name = "tempat_turun")
    private String tempatTurun;

    @Column(name = "arti")
    private String arti;

    @Column(name = "deskripsi")
    private String deskripsi;

    @OneToOne
    @JoinColumn(name = "nomor_surat_selanjutnya", referencedColumnName = "nomor", insertable = false, updatable = false)
    private SuratDAO nomorSuratSelanjutnya;

    @OneToOne
    @JoinColumn(name = "nomor_surat_sebelumnya", referencedColumnName = "nomor", insertable = false, updatable = false)
    private SuratDAO nomorSuratSebelumnya;

    @OneToMany(mappedBy = "surat", cascade = CascadeType.ALL)
    private List<AudioDAO> audioFull;

    @OneToMany(mappedBy = "surat", cascade = CascadeType.ALL)
    private List<AyatDAO> ayat;
}