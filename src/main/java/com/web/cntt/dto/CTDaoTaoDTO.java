package com.web.cntt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CTDaoTaoDTO extends AbstractDTO<CTDaoTaoDTO>{

    private String name;
    private String description;
    private String image;
}
