package com.web.cntt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sinhVien")
public class SinhVien extends BaseEntity {
    @Id
    private String maSV;
    private String ho;
    private String ten;
    private Date ngaySinh;
    private String diaChi;
    private String email;
    private String gender;
    private String sdt;

    @ManyToOne
    @JoinColumn(name = "maLop")
    private Lop maLop;
}
