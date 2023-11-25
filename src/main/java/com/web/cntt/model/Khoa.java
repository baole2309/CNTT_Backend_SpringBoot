package com.web.cntt.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    private String maKhoa;
    private String tenKhoa;
    private Date ngayThanhLap;
    private String truongKhoa;

    @OneToMany(mappedBy = "khoa", cascade = CascadeType.ALL)
    private List<GiangVien> giangViens = new ArrayList<>();
}

