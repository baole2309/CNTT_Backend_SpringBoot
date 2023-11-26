package com.web.cntt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnhNenDTO extends AbstractDTO<AnhNenDTO> {
    private String name;
    private String resource;
    private String description;
}
