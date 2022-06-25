package com.nuriza.fqw.fqw.controllers;

import com.nuriza.fqw.fqw.entity.District;
import com.nuriza.fqw.fqw.entity.Kurulush;
import com.nuriza.fqw.fqw.services.DistrictService;
import com.nuriza.fqw.fqw.services.KurulushService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/kurulush")
@RequiredArgsConstructor
public class KurulushController {
    @NonNull
    private KurulushService kurulushService;
    @NonNull
    private DistrictService districtService;

    @GetMapping
    public ResponseEntity<List<Kurulush>> getAllkurulushs() {
        return ResponseEntity.ok(kurulushService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> save(Kurulush kurulush) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(kurulushService.create(kurulush));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getKurulushByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(kurulushService.getByName(name));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Kurulush kurulush) {
        return ResponseEntity.ok().body(kurulushService.update(kurulush));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletekurulush(@PathVariable("id") Integer id) {
        Kurulush kurulush = kurulushService.getById(id);
        kurulushService.delete(kurulush);
        return ResponseEntity.ok("kurulush deleted");
    }

    @PostMapping("/district")
    public ResponseEntity<?> saveDistrict(District district) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(districtService.create(district));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
