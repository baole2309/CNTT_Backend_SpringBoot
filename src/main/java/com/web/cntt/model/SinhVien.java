package com.web.cntt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sinhVien")
public class SinhVien extends BaseEntity {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
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
    private Lop lop;
}
