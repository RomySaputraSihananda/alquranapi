DROP DATABASE IF EXISTS alquran;

CREATE DATABASE alquran;

USE alquran;

SELECT * from surat as s1 INNER JOIN surat s2 ON s1.nomor = s2.nomorSuratSelanjutnya WHERE s1.nomor = 1;

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
    id INT(6) AUTO_INCREMENT PRIMARY KEY,
    nomorAyat VARCHAR(12) NOT NULL,
    teksArab VARCHAR(255) NOT NULL,
    teksIndonesia INT(4),
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
