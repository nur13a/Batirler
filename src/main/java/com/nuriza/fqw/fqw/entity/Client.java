package com.nuriza.fqw.fqw.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Client {
    @Id
    @Column(name = "clnt_id")
    private Integer clntId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @Column(name = "clnt_cat_id")
    private ClientCategories clientCatId;
}
