package com.web.cntt.dto;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO extends AbstractDTO<PostDTO> {

    private String userId;
    private String noiDung;
    private String chuDe;
    private Date ngayDangBai;
}
