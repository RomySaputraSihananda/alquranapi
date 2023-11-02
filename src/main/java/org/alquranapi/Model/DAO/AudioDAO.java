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
@Table(name = "audio")
public class AudioDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "audio_link")
    private String audioLink;

    @ManyToOne
    @JoinColumn(name = "nomor_surat", referencedColumnName = "nomor", insertable = false, updatable = false)
    private SuratDAO surat;

    @ManyToOne
    @JoinColumn(name = "nomor_ayat", referencedColumnName = "id", insertable = false, updatable = false)
    private AyatDAO ayat;
}