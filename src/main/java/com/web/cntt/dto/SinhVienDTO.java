package com.web.cntt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVienDTO {
    private String maSV;
    private String ho;
    private String ten;
    private Date ngaySinh;
    private String diaChi;
    private String email;
    private String gender;
    private String sdt;
    private String maLop;
}