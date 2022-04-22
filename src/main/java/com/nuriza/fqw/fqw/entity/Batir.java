package com.nuriza.fqw.fqw.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Batir {
    @Id
    @Column(name = "flt_id")
    private Integer flt_id;
    private Integer room_number;
    private Integer flt_floor;
    private Integer square;
    private Integer isSell;
    private Integer Build_id;
    private Integer clientId;
    private Integer EmployeeId;
    private Date sellDate;
    private String price;

}
