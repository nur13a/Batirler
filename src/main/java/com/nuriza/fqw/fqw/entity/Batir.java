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
    @Column(name = "kurulush_id")
    private Kurulush kurulushId;

    @ManyToOne
    @Column(name = "client_id")
    private Client clientId;

    @OneToOne
    @Column(name = "employee_id")
    private Client employeeId;

    @Column(name = "sell_date")
    private Date sellDate;

    @Column(name = "price")
    private String price;

}
