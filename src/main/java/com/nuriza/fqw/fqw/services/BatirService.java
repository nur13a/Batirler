package com.nuriza.fqw.fqw.services;

import com.nuriza.fqw.fqw.entity.Batir;
import com.nuriza.fqw.fqw.models.BatirDto;

import java.util.List;

public interface BatirService extends BaseService<Batir>{
    Batir getByName(String name, Integer kurId);
    List<Integer> getPrices();
    List<Integer> getSquares();
    Batir createFromDto(BatirDto batir);
}
