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
public class Client {
    @Id
    @Column(name = "clnt_id")
    private Integer clnt_id;

    private String name;
    private Integer phone;
    private Integer clientCatId;
}
