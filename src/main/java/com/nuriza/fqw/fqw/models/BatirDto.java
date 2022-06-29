package com.nuriza.fqw.fqw.models;

import com.nuriza.fqw.fqw.entity.Client;
import com.nuriza.fqw.fqw.entity.Employee;
import com.nuriza.fqw.fqw.entity.Kurulush;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatirDto {

    private Integer roomNumber;

    private Integer batirFloor;

    private Integer square;

    private Boolean isSell;

    private String kurulushName;

    private Integer price;
}
