package com.nuriza.fqw.fqw.controllers;

import com.nuriza.fqw.fqw.entity.Batir;
import com.nuriza.fqw.fqw.entity.Client;
import com.nuriza.fqw.fqw.entity.ClientCategories;
import com.nuriza.fqw.fqw.services.ClientCatService;
import com.nuriza.fqw.fqw.services.ClientService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    @NonNull
    private ClientService clientService;
    @NonNull
    private ClientCatService clientCatService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> save(Client client) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(client));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getClientByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(clientService.getByName(name));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Client client) {
        return ResponseEntity.ok().body(clientService.update(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id) {
        Client client = clientService.getById(id);
        clientService.delete(client);
        return ResponseEntity.ok("Client deleted");
    }

    @PostMapping("/clientCat")
    public ResponseEntity<?> saveCategory(ClientCategories category) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(clientCatService.create(category));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
