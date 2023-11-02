[![Twitter: romy](https://img.shields.io/twitter/follow/RomySihananda)](https://twitter.com/RomySihananda)

# Al-Quran Services Rest API

Al-Quran Services Rest API with Sping Boot v3.2.0-SNAPSHOT </br>
and Swagger UI for Endpoint API documentation. Static File version is available [here](https://github.com/RomySaputraSihananda/alquranapi/tree/v1.0.0)

# Dependency

- org.springframework.boot:spring-boot-starter-data-jpa:**3.2.0-SNAPSHOT**
- org.springdoc:springdoc-openapi-starter-webmvc-ui:**2.2.0**
- org.projectlombok:lombok:**1.18.30**
- com.mysql:mysql-connector-j:**8.1.0**

# EndPoints

The following is a list of available Request URIs:

- **GET** API for get all surat.
  - http://127.0.0.1:4444/api/v1/alquran
- **GET** API for get detail surat.
  - http://127.0.0.1:4444/api/v1/alquran/{nomorSurat}
- **GET** API for get tafsir surat.
  - http://127.0.0.1:4444/api/v1/alquran/tafsir/{nomorSurat}
- **GET** API for search by name surat.
  - http://127.0.0.1:4444/api/v1/alquran/search/{namaSurat}

## Licence

All source code is licensed under the GNU General Public License v3. Please [see](https://www.gnu.org/licenses) the original document for more details.
