package com.web.cntt.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "giang_vien")
public class GiangVien extends BaseEntity {

    @Id
    private UUID id;
    private String maGV;
    private String ho;
    private String ten;
    private Date ngayVL;
    private String chucVu;
    private int heSoLuong;
    private String hocVi;
    private String gioiTinh;
    private String sdt;
    private String email;
    private Date ngaySinh;
}

