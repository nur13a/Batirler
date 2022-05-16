package com.nuriza.fqw.fqw.repositories;

import com.nuriza.fqw.fqw.entity.ClientCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCatRepository extends JpaRepository<Integer, ClientCategories> {
}
