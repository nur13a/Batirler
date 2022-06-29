package com.nuriza.fqw.fqw.services.impl;

import com.nuriza.fqw.fqw.entity.Kurulush;
import com.nuriza.fqw.fqw.models.KurulushDto;
import com.nuriza.fqw.fqw.repositories.DistrictRepository;
import com.nuriza.fqw.fqw.repositories.KurulushRepository;
import com.nuriza.fqw.fqw.services.DistrictService;
import com.nuriza.fqw.fqw.services.KurulushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KurulushServiceImpl implements KurulushService {
    @Autowired
    private KurulushRepository repository;
    @Autowired
    private DistrictRepository districtService;

    @Autowired
    public KurulushServiceImpl(KurulushRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Kurulush> getAll() {
        return repository.findAll();
    }

    @Override
    public Kurulush create(Kurulush kurulush) {
        return repository.save(kurulush);
    }

    @Override
    public Kurulush createFromDto(KurulushDto kurulush) {
        Kurulush k = Kurulush.builder()
                .name(kurulush.getName())
                .floor_number(kurulush.getFloor_number())
                .squareArea(kurulush.getSquareArea())
                .district(districtService.findByName(kurulush.getDistrictName()))
                .build();
        return repository.save(k);
    }

    @Override
    public Kurulush getById(Long id) {
        return repository.findById(id).orElse(new Kurulush());
    }

    @Override
    public void delete(Kurulush kurulush) {
        repository.delete(kurulush);
    }

    @Override
    public Kurulush update(Kurulush kurulush) {
        return repository.save(kurulush);
    }

    @Override
    public Kurulush getByName(String name) {
        return repository.findByName(name);
    }
}
