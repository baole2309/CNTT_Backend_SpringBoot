package com.web.cntt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LopDTO {
    private String maLop;
    private String tenLop;
    private Date ngayTL;
    private String gvCoVan;
    private String truongLop;
    private int siSo;
}
