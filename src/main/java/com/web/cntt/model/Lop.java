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
@Table(name = "lop")
public class Lop extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String maLop;
    private String tenLop;
    private Date ngayTL;
    private String gvCoVan;
    private String truongLop;
    private int siSo;

    @OneToMany(mappedBy = "lop", cascade = CascadeType.ALL)
    private List<SinhVien> sinhViens = new ArrayList<>();
}

