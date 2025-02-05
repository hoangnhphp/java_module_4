package com.codegym.songs_management.controller;

import com.codegym.songs_management.model.Song;
import com.codegym.songs_management.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String index(Model model) {
        List<Song> list = songService.findAll();
        model.addAttribute("songs", list);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Song song) {
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Song song) {
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Song song, RedirectAttributes redirect) {
        songService.remove(song.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/songs";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/view";
    }
}
