package com.web.cntt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "khoa")
public class Khoa extends BaseEntity {
    @Id
    private String maKhoa;
    private String tenKhoa;
    private Date ngayThanhLap;
    private String truongKhoa;

    @OneToMany(mappedBy = "maKhoa",cascade = CascadeType.ALL)
    private List<Lop> lops = new ArrayList<>();
}
