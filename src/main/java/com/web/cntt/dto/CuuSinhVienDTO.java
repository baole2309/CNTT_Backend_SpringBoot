package com.web.cntt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import lombok.*;
import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CuuSinhVienDTO  extends AbstractDTO<CuuSinhVienDTO> {
    private String ho;
    private String ten;
    private Date ngaySinh;
    private String address;
    private String email;
    private String gioiTinh;
    private String phoneNumber;
    private String maUser;
}