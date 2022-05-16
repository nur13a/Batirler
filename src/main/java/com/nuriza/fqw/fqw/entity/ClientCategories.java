package com.nuriza.fqw.fqw.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClientCategories {
    @Id
    @Column(name = "cat_id")
    private Integer catId;

    @Column(name = "name")
    private String name;

}

