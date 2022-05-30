package com.nuriza.fqw.fqw.controllers;

import com.nuriza.fqw.fqw.entity.Batir;
import com.nuriza.fqw.fqw.entity.Client;
import com.nuriza.fqw.fqw.services.BatirService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/batir")
public class BatirController {
    private BatirService batirService;

    @GetMapping
    public List<Batir> getAllBatirs() {
        return batirService.getAll();
    }

    @PostMapping
    public String save(Batir batir) {
        try {
            batirService.create(batir);
            return "Batir успешно сохранен";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    /*@GetMapping("/{name}")
    public Client getClientByName(@PathVariable("name") String name){
        return batirService.getByName(name);
    }*/
}
