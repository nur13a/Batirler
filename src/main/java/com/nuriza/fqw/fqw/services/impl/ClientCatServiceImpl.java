package com.nuriza.fqw.fqw.services.impl;

import com.nuriza.fqw.fqw.entity.ClientCategories;
import com.nuriza.fqw.fqw.repositories.BatirRepository;
import com.nuriza.fqw.fqw.repositories.ClientCatRepository;
import com.nuriza.fqw.fqw.services.ClientCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCatServiceImpl implements ClientCatService {
    private ClientCatRepository repository;

    @Autowired
    public  ClientCatServiceImpl (ClientCatRepository clientCatRepository){
        this.repository = clientCatRepository;
    }

    @Override
    public List<ClientCategories> getAll() {
        return repository.findAll();
    }

    @Override
    public void create(ClientCategories clientCategories) {
        repository.save(clientCategories);
    }

    @Override
    public ClientCategories getById(Integer id) {
        return repository.findById(id).orElse(new ClientCategories());
    }

    @Override
    public void delete(ClientCategories clientCategories) {
        repository.delete(clientCategories);
    }

    @Override
    public ClientCategories update(ClientCategories clientCategories) {
        return repository.save(clientCategories);
    }
}
