package com.greta.demopage.controller;

import com.greta.demopage.model.entity.Episode;
import com.greta.demopage.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EpisodeController {

    private EpisodeService episodeService;

    @Autowired
    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }
//Simple pagination
    @GetMapping("/episode")
    public String getAllEpisodes(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String titre) {
        Pageable pageable = PageRequest.of(page, 6);
        Page<Episode> episodes= episodeService.getPageEtRecherche(titre,pageable);
        model.addAttribute("pageNumber",page);
        model.addAttribute("pageEpisodes",episodes);
        return "episode/indexPagination";
    }

    //Pagination avec trie
    @GetMapping("/episode/order")
    public String getAllEpisodes(Model model,
            @RequestParam(defaultValue = "num") String sortBy,
            @RequestParam(defaultValue = "false") boolean sortDirection,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int pageSize) {

        Sort.Direction direction = sortDirection == true ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(direction, sortBy));

        Page<Episode> episodes= episodeService.getAll(pageable);
        model.addAttribute("sortDirection",sortDirection);
        model.addAttribute("pageEpisodes",episodes);
        return "episode/indexOrder";
    }
}
