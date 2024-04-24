package com.greta.demopage.model.dao;

import com.greta.demopage.model.entity.Episode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    Page<Episode> findByTitreContainsIgnoreCaseOrderBySaison_Serie_NomAscSaison_NumAsc(String titre, Pageable pageable);
}