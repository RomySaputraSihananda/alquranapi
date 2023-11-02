package org.alquranapi.Model.DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tafsir")
public class TafsirDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "teks")
    private String teks;

    @Column(name = "ayat")
    private int nomotAyat;

    @ManyToOne
    @JoinColumn(name = "id_ayat", referencedColumnName = "id", insertable = false, updatable = false)
    private AyatDAO ayat;
}
