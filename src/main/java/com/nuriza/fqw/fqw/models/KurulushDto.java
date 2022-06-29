package com.nuriza.fqw.fqw.models;

import com.nuriza.fqw.fqw.entity.District;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KurulushDto {
    private String name;

    private Integer squareArea;

    private String districtName;

    private Integer floor_number;
}
