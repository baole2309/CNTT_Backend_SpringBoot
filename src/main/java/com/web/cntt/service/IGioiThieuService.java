package com.web.cntt.service;

import com.web.cntt.dto.GiangVienDTO;
import com.web.cntt.dto.GioiThieuDTO;
import com.web.cntt.model.GiangVien;
import com.web.cntt.model.GioiThieu;

import java.util.List;

public interface IGioiThieuService {
    public List<GioiThieu> getAllGioiThieu();
    public GioiThieu addGioiThieu(GioiThieuDTO request);
    public GioiThieu updateGioiThieu(GioiThieuDTO request, String id);
    public GioiThieu getGioiThieuById(String id);
    public void deleteGioiThieu(String id);
}
