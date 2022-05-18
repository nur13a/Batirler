package com.nuriza.fqw.fqw.services.impl;

import com.nuriza.fqw.fqw.entity.Batir;
import com.nuriza.fqw.fqw.repositories.BatirRepository;
import com.nuriza.fqw.fqw.services.BatirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatirServiceImpl implements BatirService {

    private BatirRepository repository;
    private final CorrelationServiceImpl correlationService;
    @Autowired
    public  BatirServiceImpl (BatirRepository batirRepository){
        this.repository = batirRepository;
    }

    @Override
    public List<Batir> getAll() {
        return repository.findAll();
    }

    @Override
    public void create(Batir batir) {
repository.save(batir);
    }

    @Override
    public Batir getById(Integer id) {
        return repository.findById(id).orElse(new Batir());
    }

    @Override
    public void delete(Batir batir) {
repository.delete(batir);
    }

    @Override
    public Batir update(Batir batir) {
        return repository.save(batir);
    }
}
