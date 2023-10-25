# apiquran
Sangat penting bagi umat muslim untuk membaca dan menghafal al-quran\
karena hal tersebut apiquran hadir. Apiquran adalah pustaka untuk membuat\
aplikasi al-quran berisi informasi surah, terjemahan ayat\
dalam bahasa indonesia, bahasa latin, serta dilengkapi dengan Juz al-quran.

## Contoh program
```python
from apiquran import Surah 
from apiquran import Juz
import pprint


# menampilkan ayat berdasarkan surah
def tampilkan(surah_quran: Surah):
    jumlah_ayat = surah_quran.data[3]
    for i in range(jumlah_ayat):
        print(aa.ayat[str(i+1)]['teksArab'])
        print(aa.ayat[str(i+1)]['teksLatin'])
        print(aa.ayat[str(i+1)]['teksIndonesia'])
        print()
        
# menampilkan ayat berdasarkan juz
def data_juz(nomor_urut: int):
    return Juz(nomor_urut).data

if __name__ == '__main__': 
    aa = Surah(1)
    tampilkan(aa)
    
    jz = Juz(1)
    pprint.pprint(jz.data, sort_dicts=False)

```
## Pengelompokan berdasarkan surah
Pada kelas Surah terdapat dua atribut, penjelasannya sebagai berikut.
- Surah(parameter).data
  - Mengembalikan informasi surah tersebut berdasarkan perameter
  bertipe data int. informasi ini akan memiliki tipe data tuple berurutan
  berupa nomor, nama dalam bahasa arab, nama dalam bahasa indonesia, jumlah ayat surah, tempat turunnya surah,
  dan artinya dalam bahasa indonesia.
---
- Surah(parameter).ayat
  - Mengembalikan ayat berdasarkan parameter bertipe data int.
---
## Pengelompokan berdasarkan juz
- Juz(parameter).data 
	- untuk mengelompokan ayat berdasarkan juz dengan memasukan
	berupa data bertipe int sebagai penggati parameter,
	mengembalikan data bertipe dict[str, tuple].

## Sumber
api ini dibuat berdasarkan api [equran](https://equran.id/apidev)
