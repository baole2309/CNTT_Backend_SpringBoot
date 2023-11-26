//package com.web.cntt.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.JavaType;
//
//import java.util.Date;
//import java.util.UUID;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "cuuSinhVien")
//public class CuuSinhVien extends BaseEntity {
//    @Id
//    private String maCuuSV;
//    private String ho;
//    private String ten;
//    private Date ngaySinh;
//    private String address;
//    private String email;
//    private String gioiTinh;
//    private String phoneNumber;
//    @OneToOne
//    @JoinColumn(name = "maUser")
//    private User user;
//
//    public String getMaCuuSV() {
//        return maCuuSV;
//    }
//
//    public void setMaCuuSV(String maCuuSV) {
//        this.maCuuSV = maCuuSV;
//    }
//
//    public String getHo() {
//        return ho;
//    }
//
//    public void setHo(String ho) {
//        this.ho = ho;
//    }
//
//    public String getTen() {
//        return ten;
//    }
//
//    public void setTen(String ten) {
//        this.ten = ten;
//    }
//
//    public Date getNgaySinh() {
//        return ngaySinh;
//    }
//
//    public void setNgaySinh(Date ngaySinh) {
//        this.ngaySinh = ngaySinh;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getGioiTinh() {
//        return gioiTinh;
//    }
//
//    public void setGioiTinh(String gioiTinh) {
//        this.gioiTinh = gioiTinh;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public User getMaUser() {
//        return user;
//    }
//
//    public void setMaUser(User user) {
//        this.user = user;
//    }
//}
