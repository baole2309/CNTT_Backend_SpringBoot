package com.web.cntt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTieuDTO extends AbstractDTO<ChiTieuDTO> {
    private String maNganh;
    private String tenNganh;
    private int nam;
    private double diemChuan;
    private int chiTieu;
}
