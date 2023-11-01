package org.alquranapi.Model.DAO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne
    @JoinColumn(name = "nomor_surat_selanjutnya", referencedColumnName = "nomor", insertable = false, updatable = false)
    private SuratDAO nomorSuratSelanjutnya;

    @ManyToOne
    @JoinColumn(name = "nomor_surat_sebelumnya", referencedColumnName = "nomor", insertable = false, updatable = false)
    private SuratDAO nomorSuratSebelumnya;

    @JsonManagedReference
    @OneToMany(mappedBy = "surat", cascade = CascadeType.ALL)
    private List<AudioDAO> audioFull;
}