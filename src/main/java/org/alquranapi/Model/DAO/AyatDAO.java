package org.alquranapi.Model.DAO;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ayat")
public class AyatDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "nomor_ayat")
    private int nomorAyat;

    @Column(name = "teks_arab")
    private String teksArab;

    @Column(name = "teks_latin")
    private String teksLatin;

    @Column(name = "teks_indonesia")
    private String teksIndonesia;

    @OneToMany(mappedBy = "ayat", cascade = CascadeType.ALL)
    private List<AudioDAO> audio;

    @OneToOne(mappedBy = "ayat")
    private TafsirDAO tafsir;

    @ManyToOne
    @JoinColumn(name = "nomor_surat", referencedColumnName = "nomor", insertable = false, updatable = false)
    private SuratDAO surat;
}
