package com.nuriza.fqw.fqw.services;

import com.nuriza.fqw.fqw.entity.Batir;
import com.nuriza.fqw.fqw.entity.Kurulush;

public interface KurulushService extends BaseService<Kurulush> {
    Kurulush getByName(String name);
}
