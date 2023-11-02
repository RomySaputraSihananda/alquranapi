package org.alquranapi.repository;

import org.alquranapi.Model.DAO.SuratDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SuratRepository extends JpaRepository<SuratDAO, Integer> {
    public SuratDAO getByNomor(long nomor);

    public List<SuratDAO> findByNamaLatinContaining(String namaLatin);
}
