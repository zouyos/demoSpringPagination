package com.greta.demopage.model.dao;

import com.greta.demopage.model.entity.Saison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaisonRepository extends JpaRepository<Saison, Long> {
}