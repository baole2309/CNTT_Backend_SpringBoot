package com.web.cntt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BanDieuHanhDTO extends AbstractDTO<BanDieuHanhDTO>{
    private String firstName;
    private String lastName;
    private String chucVu;
    private String description;
    private String email;
    private String phoneNumber;
    private String image;
}
