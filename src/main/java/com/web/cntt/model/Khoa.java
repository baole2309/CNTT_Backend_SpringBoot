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
@Table(name = "khoa")
public class Khoa extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

