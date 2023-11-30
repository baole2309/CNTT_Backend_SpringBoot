package com.web.cntt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class GTCuuSVDTO extends AbstractDTO<GTCuuSVDTO> {
    private String title;
    private String description;
    private String aim;
    private String image;
    private Date ngayTB;
}
