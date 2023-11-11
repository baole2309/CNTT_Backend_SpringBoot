package com.web.cntt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chiTieu")
public class ChiTieu extends BaseEntity{
    @Id
    private UUID maChiTieu;
    private String maNganh;
    private String tenNganh;
    private int year;
    private double diemChuan;
    private int chiTieu;

}
