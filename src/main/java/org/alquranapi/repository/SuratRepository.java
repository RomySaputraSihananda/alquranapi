package org.alquranapi.repository;

import org.alquranapi.Model.DAO.SuratDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuratRepository extends JpaRepository<SuratDAO, Long> {
}
