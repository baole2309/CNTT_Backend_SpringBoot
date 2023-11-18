package com.web.cntt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "giangVien")
public class GiangVien extends BaseEntity {
    @Id
    private String maGV;
    private String firstName;
    private String lastName;
    private Date ngayVL;
    private String chucVu;
    private int heSoLuong;
    private double mucLuong;
    private String hocVi;
    private String gender;
    private String email;
    private String phoneNumber;
    private Date birthOfDate;
}
