package com.nuriza.fqw.fqw.controllers;

import com.nuriza.fqw.fqw.entity.Batir;
import com.nuriza.fqw.fqw.models.BatirDto;
import com.nuriza.fqw.fqw.services.BatirService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/batir")
public class BatirController {
    @NonNull
    private BatirService batirService;


    @GetMapping("/list")
    public ModelAndView showBatirs() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("batirs", batirService.getAll());
        return mav;
    }

    @GetMapping
    public List<Batir> getAllBatirs() {
        return batirService.getAll();
    }

    @PostMapping("/saveBatir")
    public ModelAndView saveEmployee(@ModelAttribute BatirDto batir) {
        batirService.createFromDto(batir);
        return new ModelAndView("redirect:list");
    }

    @GetMapping("/{name}/{kurulush_id}")
    public ResponseEntity<?> getBatirByName(@PathVariable("name") String name, @PathVariable("kurulush_id") Integer kur_id) {
        return ResponseEntity.ok().body(batirService.getByName(name, kur_id));
    }

    @GetMapping("/updateBatirForm")
    public ModelAndView update(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("addBatir");
        Batir batir = batirService.getById(id);
        mav.addObject("batir", batir);
        return mav;
    }

    @GetMapping("/addBatirForm")
    public ModelAndView addBatir() {
        ModelAndView mav = new ModelAndView("addBatir");
        BatirDto batir = new BatirDto();
        mav.addObject("batir", batir);
        return mav;
    }

    @GetMapping("/deleteBatir")
    public ModelAndView deleteBatir(@RequestParam Long id) {
        Batir batir = batirService.getById(id);
        batirService.delete(batir);

        return new ModelAndView("redirect:list");
    }
}
