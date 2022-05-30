package com.nuriza.fqw.fqw.services.impl;

import com.nuriza.fqw.fqw.entity.Client;
import com.nuriza.fqw.fqw.repositories.ClientRepository;
import com.nuriza.fqw.fqw.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository repository;

    @Autowired
    public ClientServiceImpl (ClientRepository repository){
        this.repository=repository;
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }

    @Override
    public void create(Client client) {
        repository.save(client);
    }

    @Override
    public Client getById(Integer id) {
        return repository.findById(id).orElse(new Client());
    }

    @Override
    public void delete(Client client) {
        repository.delete(client);
    }

    @Override
    public Client update(Client client) {
        return repository.save(client);
    }

    @Override
    public Client getByName(String name) {
        return repository.findByName(name);
    }
}
