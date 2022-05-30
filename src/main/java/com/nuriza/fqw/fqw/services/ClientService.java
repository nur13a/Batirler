package com.nuriza.fqw.fqw.services;

import com.nuriza.fqw.fqw.entity.Client;

public interface ClientService extends BaseService<Client> {
    Client getByName(String name);
}
