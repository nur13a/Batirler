package com.nuriza.fqw.fqw.controllers;

import com.nuriza.fqw.fqw.entity.Batir;
import com.nuriza.fqw.fqw.entity.District;
import com.nuriza.fqw.fqw.services.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("api/v1/district")
@RequiredArgsConstructor
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping("/addDistrict")
    public ModelAndView addDistrict() {
        ModelAndView mav = new ModelAndView("addDistrict");
        District district = new District();
        mav.addObject("district", district);
        return mav;
    }

    @PostMapping("/saveDistrict")
    public ModelAndView saveDistrict(@ModelAttribute District district) {
        districtService.create(district);
        return new ModelAndView("redirect:list");
    }

    @GetMapping("/list")
    public ModelAndView showDistricts() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("districtView");
        mav.addObject("districts", districtService.getAll());
        return mav;
    }
    @GetMapping("/updateDistrictForm")
    public ModelAndView update(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("addDistrict");
        District district = districtService.getById(id);
        mav.addObject("district", district);
        return mav;
    }
}
