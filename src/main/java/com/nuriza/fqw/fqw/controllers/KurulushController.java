package com.nuriza.fqw.fqw.controllers;

import com.nuriza.fqw.fqw.entity.Kurulush;
import com.nuriza.fqw.fqw.entity.District;
import com.nuriza.fqw.fqw.models.KurulushDto;
import com.nuriza.fqw.fqw.services.DistrictService;
import com.nuriza.fqw.fqw.services.KurulushService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("api/v1/kurulush")
@RequiredArgsConstructor
public class KurulushController {
    @NonNull
    private KurulushService kurulushService;
    @NonNull
    private DistrictService districtService;


    @GetMapping("/list")
    public ModelAndView showKurulushs() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("kurulushView");
        mav.addObject("kurulushs", kurulushService.getAll());
        return mav;
    }

    @PostMapping("/saveKurulush")
    public ModelAndView saveEmployee(@ModelAttribute KurulushDto Kurulush) {
        kurulushService.createFromDto(Kurulush);
        return new ModelAndView("redirect:list");
    }

    @GetMapping("/{name}/{kurulush_id}")
    public ResponseEntity<?> getKurulushByName(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(kurulushService.getByName(name));
    }

    @GetMapping("/updateKurulushForm")
    public ModelAndView update(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("addKurulush");
        Kurulush Kurulush = kurulushService.getById(id);
        mav.addObject("Kurulush", Kurulush);
        return mav;
    }

    @GetMapping("/addKurulushForm")
    public ModelAndView addKurulush() {
        ModelAndView mav = new ModelAndView("addKurulushAndDistrict");
        KurulushDto dto = new KurulushDto();
        mav.addObject("dto", dto);
        return mav;
    }

    @GetMapping("/deleteKurulush")
    public ModelAndView deleteKurulush(@RequestParam Long id) {
        Kurulush Kurulush = kurulushService.getById(id);
        kurulushService.delete(Kurulush);
        return new ModelAndView("redirect:list");
    }
}
