package com.web.cntt.dto;
import com.web.cntt.model.Khoa;
import lombok.*;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GiangVienDTO   extends AbstractDTO<GiangVienDTO> {
    private String ho;
    private String ten;
    private Date ngayVL;
    private String chucVu;
    private int heSoLuong;
    private String hocVi;
    private String gioiTinh;
    private String sdt;
    private String email;
    private Date ngaySinh;
    private String maKhoa;
}

