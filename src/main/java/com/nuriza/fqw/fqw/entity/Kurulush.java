package com.nuriza.fqw.fqw.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Kurulush {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kurulush_id")
    private Long kurulushId;

    @Column(name = "name")
    private String name;

    @Column(name = "square_area")
    private Integer squareArea;

    @ManyToOne
    @JoinColumn(name = "district")
    private District district;

    @Column(name = "floor_number")
    private Integer floor_number;

}
