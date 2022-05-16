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
public class Kurulush {
    @Id
    @Column(name = "kurulush_id")
    private Integer kurulushId;

    @Column(name = "name")
    private String name;

    @Column(name = "square_area")
    private Integer squareArea;

    @ManyToOne
    @Column(name = "district")
    private District district;

    @Column(name = "name")
    private Integer floor_number;

}
