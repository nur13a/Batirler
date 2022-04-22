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
public class Kurulush {
    @Id
    @Column(name = "flt_id")
    private Integer bld_id;

    private String name;
    private Integer squareArea;
    private Integer DistrictArea;
    private Integer floor_number;

}
