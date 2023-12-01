package com.web.cntt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    private String maLop;
    private String tenLop;
    private Date ngayTL;
    private String gvCoVan;
    private String truongLop;
    private int siSo;

    @OneToMany(mappedBy = "lop", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SinhVien> sinhViens = new ArrayList<>();
}

