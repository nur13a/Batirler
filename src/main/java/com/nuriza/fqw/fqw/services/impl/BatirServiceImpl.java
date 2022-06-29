package com.nuriza.fqw.fqw.services.impl;

import com.nuriza.fqw.fqw.entity.Batir;
import com.nuriza.fqw.fqw.models.BatirDto;
import com.nuriza.fqw.fqw.repositories.BatirRepository;
import com.nuriza.fqw.fqw.services.BatirService;
import com.nuriza.fqw.fqw.services.KurulushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class BatirServiceImpl implements BatirService {

    @Autowired
    private BatirRepository repository;

    @Autowired
    private KurulushService kurulushService;

    @Override
    public List<Batir> getAll() {
        return repository.findAll();
    }

    @Override
    public Batir create(Batir batir) {
        return repository.save(batir);
    }

    @Override
    public Batir createFromDto(BatirDto batir) {
        Batir b = Batir.builder()
                .batirFloor(batir.getBatirFloor())
                .isSell(batir.getIsSell())
                .price(batir.getPrice())
                .square(batir.getSquare())
                .kurulushId(kurulushService.getByName(batir.getKurulushName()))
                .build();
        return repository.save(b);
    }

    @Override
    public Batir getById(Long id) {
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


    @Override
    public Batir getByName(String name, Integer id) {
        return repository.findByRoomNumberAndKurulushId(name, id);
    }

    @Override
    public List<Integer> getPrices() {
        List<Integer> priceList = new ArrayList<>();
        for (Batir b : repository.findAll()) {
            priceList.add(b.getPrice());
        }
        return priceList;
    }

    @Override
    public List<Integer> getSquares() {
        List<Integer> squareList = new ArrayList<>();
        for (Batir b : repository.findAll()) {
            squareList.add(b.getSquare());
        }
        return squareList;
    }
}
