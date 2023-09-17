package com.greta.demopage.service;

import com.greta.demopage.model.dao.EpisodeRepository;
import com.greta.demopage.model.entity.Episode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EpisodeService {
    private EpisodeRepository episodeRepository;

    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    public Page<Episode> getAll(Pageable pageable) {
        return episodeRepository.findAll(pageable);
    }
}
