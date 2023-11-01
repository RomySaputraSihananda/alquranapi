DROP DATABASE IF EXISTS alquran;

CREATE DATABASE alquran;

USE alquran;

CREATE TABLE surat(
    nomor INT(4) PRIMARY KEY NOT NULL,
    nama NVARCHAR(100) NOT NULL,
    nama_latin VARCHAR(100) NOT NULL,
    jumlah_ayat INT(6) NOT NULL,
    tempat_turun VARCHAR(100) NOT NULL,
    arti VARCHAR(100) NOT NULL,
    deskripsi TEXT NOT NULL,
    nomor_surat_selanjutnya INT(4),
    nomor_surat_sebelumnya INT(4),
    FOREIGN KEY (nomor_surat_selanjutnya) REFERENCES surat(nomor),
    FOREIGN KEY (nomor_surat_sebelumnya) REFERENCES surat(nomor)
);

CREATE TABLE ayat(
    id VARCHAR(7) PRIMARY KEY NOT NULL,
    nomor_ayat INT(3) NOT NULL,
    teks_arab NVARCHAR(10000) NOT NULL,
    teks_latin NVARCHAR(10000) NOT NULL,
    teks_indonesia TEXT NOT NULL,
    nomor_surat INT(4),
    FOREIGN KEY (nomor_surat) REFERENCES surat(nomor)
);

CREATE TABLE audio(
    id INT(7) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    audio_link VARCHAR(255) NOT NULL,
    nomor_surat INT(4),
    nomor_ayat VARCHAR(7),
    FOREIGN KEY (nomor_surat) REFERENCES surat(nomor),
    FOREIGN KEY (nomor_ayat) REFERENCES ayat(id)
);
