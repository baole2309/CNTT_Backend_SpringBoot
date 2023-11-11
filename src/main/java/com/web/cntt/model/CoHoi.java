package com.web.cntt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coHoi")
public class CoHoi {
    @Id
    private UUID maCoHoi;
    private String cHHocTap;
    private String cHViecLam;
    private String cHThucTap;
    private String cHNhanHocBong;
    private String cHGiaoLuu;
    private String cHMienPhiNoiTru;
    private String cHPhatTrien;
    private String cHHopTac;

}
