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
public class District {
    @Id
    @Column(name = "district_id")
    private Integer districtId;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "is_quiet")
    private Integer isQuiet;

    @Column(name = "square")
    Integer square;
}
