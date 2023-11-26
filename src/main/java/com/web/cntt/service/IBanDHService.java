package com.web.cntt.service;

import com.web.cntt.dto.BanDieuHanhDTO;
import com.web.cntt.model.BanDieuHanh;

import java.util.List;

public interface IBanDHService {
    public List<BanDieuHanh> getAllBanDH();
    public BanDieuHanh getBanDieuHanhById(String id);
    public BanDieuHanh addBanDH(BanDieuHanhDTO request);
    public BanDieuHanh updateBanDH(BanDieuHanhDTO request, String id);
    public void deleteBanDH(String id);
}
