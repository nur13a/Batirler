package com.nuriza.fqw.fqw.repositories;

import com.nuriza.fqw.fqw.entity.Batir;
import com.nuriza.fqw.fqw.entity.Client;
import com.nuriza.fqw.fqw.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District,Long > {
    District findByName(String name);
}
