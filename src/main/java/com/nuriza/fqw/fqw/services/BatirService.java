package com.nuriza.fqw.fqw.services;

import com.nuriza.fqw.fqw.entity.Batir;

import java.util.List;

public interface BatirService extends BaseService<Batir>{
    Batir getByName(String name, Integer kurId);
    List<Integer> getPrices();
    List<Integer> getSquares();
}
