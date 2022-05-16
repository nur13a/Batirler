package com.nuriza.fqw.fqw.repositories;

import com.nuriza.fqw.fqw.entity.Batir;
import com.nuriza.fqw.fqw.entity.Kurulush;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KurulushRepository extends JpaRepository<Integer, Kurulush> {
}
