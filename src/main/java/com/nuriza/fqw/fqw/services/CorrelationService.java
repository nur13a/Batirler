package com.nuriza.fqw.fqw.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CorrelationService {
    public Double getCorrelationBatir();

    Double calculatePearsonCorrelationCoef(List<Integer> x, List<Integer> y, int n);
}
