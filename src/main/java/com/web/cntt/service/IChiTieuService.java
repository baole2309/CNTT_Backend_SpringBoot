package com.web.cntt.service;

import com.web.cntt.dto.BanDieuHanhDTO;
import com.web.cntt.dto.ChiTieuDTO;
import com.web.cntt.model.BanDieuHanh;
import com.web.cntt.model.ChiTieu;

import java.util.List;

public interface IChiTieuService {
    public List<ChiTieu> getAllChiTieu();
    public ChiTieu getChiTieuById(String id);
    public ChiTieu addChiTieu(ChiTieuDTO request);
    public ChiTieu updateChiTieu(ChiTieuDTO request, String id);
    public void deleteChiTieu(String id);
}
