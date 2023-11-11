package com.web.cntt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lop")
public class Lop extends BaseEntity{
    @Id
    private String maLop;
    private String tenLop;
    private Date ngayTL;
    private String gvCoVan;
    private String truongLop;
    private int siSo;

    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private Khoa maKhoa;

    @OneToMany(mappedBy = "maLop",cascade = CascadeType.ALL)
    private List<SinhVien> sinhViens = new ArrayList<>();
}
