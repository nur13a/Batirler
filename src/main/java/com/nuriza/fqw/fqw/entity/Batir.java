package com.nuriza.fqw.fqw.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Batir {
    @Id
    @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    @Column(name = "batir_id")
    private Long batirId;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "batir_floor")
    private Integer batirFloor;

    @Column(name = "square")
    private Integer square;

    @Column(name = "is_sell")
    private Boolean isSell;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kurulush_id")
    private Kurulush kurulushId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "sell_date")
    private Date sellDate;

    @Column(name = "price")
    private Integer price;

}
