package com.nuriza.fqw.fqw.controllers;

import com.nuriza.fqw.fqw.entity.Kurulush;
import com.nuriza.fqw.fqw.services.CorrelationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/correlation")
@RequiredArgsConstructor
public class CorrelationController {
@NonNull private CorrelationService correlationService;
    @GetMapping
    public ResponseEntity<?> getAllkurulushs() {
        return ResponseEntity.ok(correlationService.getCorrelationBatir());
    }

}
