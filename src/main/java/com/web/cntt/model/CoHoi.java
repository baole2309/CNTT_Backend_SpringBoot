package com.web.cntt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coHoi")
public class CoHoi {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    @Column(length = 10000)
    private String cHHocTap;
    @Column(length = 10000)
    private String cHViecLam;
    @Column(length = 10000)
    private String cHThucTap;
    @Column(length = 10000)
    private String cHNhanHocBong;
    @Column(length = 10000)
    private String cHGiaoLuu;
    @Column(length = 10000)
    private String cHMienPhiNoiTru;
    @Column(length = 10000)
    private String cHPhatTrien;
    @Column(length = 10000)
    private String cHHopTac;

}
