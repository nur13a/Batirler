package com.nuriza.fqw.fqw.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Batir {
    @Id
    @Column(name = "batir_id")
    private Integer batirId;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "batir_floor")
    private Integer batirFloor;

    @Column(name = "square")
    private Integer square;

    @Column(name = "is_sell")
    private Integer isSell;

    @ManyToOne
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
