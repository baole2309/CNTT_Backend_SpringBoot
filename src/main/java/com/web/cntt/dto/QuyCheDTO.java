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
public class QuyCheDTO extends AbstractDTO<AnhNenDTO>{
    private String tenQuyChe;
    private String content;
    private Date ngayApDung;
}
