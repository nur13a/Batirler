package com.nuriza.fqw.fqw.controllers;

import com.nuriza.fqw.fqw.entity.Batir;
import com.nuriza.fqw.fqw.services.BatirService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/batir")
public class BatirController {
    @NonNull private BatirService batirService;

    @GetMapping
    public List<Batir> getAllBatirs() {
        return batirService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> save(Batir batir) {
        try {
            return ResponseEntity.ok().body(batirService.create(batir));
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/{name}/{kurulush_id}")
    public ResponseEntity<?> getBatirByName(@PathVariable("name") String name, @PathVariable("kurulush_id") Integer kur_id) {
        return ResponseEntity.ok().body(batirService.getByName(name, kur_id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Batir batir) {
        return ResponseEntity.ok().body(batirService.update(batir));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBatir(@PathVariable("id") Integer id) {
        Batir batir = batirService.getById(id);
        batirService.delete(batir);
        return ResponseEntity.ok("Batir deleted");
    }
}
