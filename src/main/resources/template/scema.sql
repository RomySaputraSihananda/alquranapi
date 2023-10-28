DROP DATABASE IF EXISTS alquran;

CREATE DATABASE alquran;

USE alquran;

CREATE TABLE surat(
    nomor INT(4) PRIMARY KEY NOT NULL,
    nama NVARCHAR(100) NOT NULL,
    namaLatin VARCHAR(100) NOT NULL,
    jumlahAyat INT(6) NOT NULL,
    tempatTurun VARCHAR(100) NOT NULL,
    arti VARCHAR(100) NOT NULL,
    deskripsi TEXT NOT NULL,
    nomorSuratSelanjutnya INT(4),
    nomorSuratSebelumnya INT(4),
    FOREIGN KEY (nomorSuratSelanjutnya) REFERENCES surat(nomor),
    FOREIGN KEY (nomorSuratSebelumnya) REFERENCES surat(nomor)
);

CREATE TABLE ayat(
    id INT(6) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nomorAyat INT(3) NOT NULL,
    teksArab NVARCHAR(10000) NOT NULL,
    teksLatin NVARCHAR(10000) NOT NULL,
    teksIndonesia TEXT NOT NULL,
    nomorSurat INT(4),
    FOREIGN KEY (nomorSurat) REFERENCES surat(nomor)
);

CREATE TABLE audio(
    id INT(6) AUTO_INCREMENT PRIMARY KEY,
    nomorAudio VARCHAR(12) NOT NULL,
    audioLink VARCHAR(255) NOT NULL,
    nomorSurat INT(4),
    nomorAyat INT(4),
    FOREIGN KEY (nomorSurat) REFERENCES surat(nomor),
    FOREIGN KEY (nomorAyat) REFERENCES ayat(id)
);
