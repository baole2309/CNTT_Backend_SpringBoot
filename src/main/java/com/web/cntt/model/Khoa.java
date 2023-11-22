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



    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public Date getNgayThanhLap() {
        return ngayThanhLap;
    }

    public void setNgayThanhLap(Date ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }

    public String getTruongKhoa() {
        return truongKhoa;
    }

    public void setTruongKhoa(String truongKhoa) {
        this.truongKhoa = truongKhoa;
    }

    public List<Lop> getLops() {
        return lops;
    }

    public void setLops(List<Lop> lops) {
        this.lops = lops;
    }
}
