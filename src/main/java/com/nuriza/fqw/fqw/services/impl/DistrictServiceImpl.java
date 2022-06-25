package com.nuriza.fqw.fqw.services.impl;

import com.nuriza.fqw.fqw.entity.District;
import com.nuriza.fqw.fqw.repositories.DistrictRepository;
import com.nuriza.fqw.fqw.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {
    private DistrictRepository repository;
    @Autowired
    public DistrictServiceImpl (DistrictRepository repository){
        this.repository=repository;
    }

    @Override
    public List<District> getAll() {
        return repository.findAll();
    }

    @Override
    public District create(District district) {
return repository.save(district);
    }

    @Override
    public District getById(Integer id) {
        return repository.findById(id).orElse(new District());
    }

    @Override
    public void delete(District district) {
repository.save(district);
    }

    @Override
    public District update(District district) {
        return repository.save(district);
    }
}
