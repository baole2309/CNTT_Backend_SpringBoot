package com.web.cntt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuuSinhVien")
public class CuuSinhVien extends BaseEntity {
    @Id
    private String maCuuSV;
    private String ho;
    private String ten;
    private Date ngaySinh;
    private String address;
    private String email;
    private String gioiTinh;
    private String phoneNumber;
    private String maUser;

    public CuuSinhVien(String maCuuSV, String ho, String ten, Date ngaySinh, String address, String email, String gioiTinh, String phoneNumber, String maUser) {
        this.maCuuSV = maCuuSV;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.address = address;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.phoneNumber = phoneNumber;
        this.maUser = maUser;
    }

    public String getMaCuuSV() {
        return maCuuSV;
    }

    public void setMaCuuSV(String maCuuSV) {
        this.maCuuSV = maCuuSV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMaUser() {
        return maUser;
    }

    public void setMaUser(String maUser) {
        this.maUser = maUser;
    }
}
