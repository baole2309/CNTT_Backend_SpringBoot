package com.web.cntt.dto;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KhoaDTO  extends AbstractDTO<KhoaDTO> {
    private String tenKhoa;
    private Date ngayTL;
    private String truongKhoa;

}
