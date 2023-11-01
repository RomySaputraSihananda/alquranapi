package org.alquranapi.repository;

import org.alquranapi.Model.DAO.AudioDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<AudioDAO, Long> {
}
