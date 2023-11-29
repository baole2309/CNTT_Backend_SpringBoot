package com.web.cntt.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "khoa")
public class Khoa extends BaseEntity {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    @Column(name = "maKhoa")
    private String maKhoa;
    @Column(name = "tenKhoa")
    private String tenKhoa;
    @Column(name = "ngayThanhLap")
    private Date ngayThanhLap;
    @Column(name = "truongKhoa")
    private String truongKhoa;

}

