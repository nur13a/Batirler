package com.nuriza.fqw.fqw.controllers;

import com.nuriza.fqw.fqw.entity.Client;
import com.nuriza.fqw.fqw.services.ClientService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAll();
    }

    @PostMapping
    public String save(Client client) {
        try {
            clientService.create(client);
            return "Клиент успешно сохранен";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @GetMapping("/{name}")
    public Client getClientByName(@PathVariable("name") String name){
        return clientService.getByName(name);
    }
}
