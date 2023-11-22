package com.web.cntt.dto;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO extends AbstractDTO<UserDTO> {

    private String maPost;
    private String userId;
    private String noiDung;
    private String chuDe;
    private Date ngayDangBai;
}
