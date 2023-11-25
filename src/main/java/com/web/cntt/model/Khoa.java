package com.web.cntt.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "khoa")
public class Khoa extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String maKhoa;
    private String tenKhoa;
    private Date ngayThanhLap;
    private String truongKhoa;

    @OneToMany(mappedBy = "maKhoa",cascade = CascadeType.ALL)
    private List<Lop> lops = new ArrayList<>();


}
