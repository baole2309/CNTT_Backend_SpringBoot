package com.web.cntt.service;

import com.web.cntt.dto.GiangVienDTO;
import com.web.cntt.model.GiangVien;

import java.util.List;

public interface IGiangVienService {
    public List<GiangVien> getAllGiangVien();
    public GiangVien addGiangVien(GiangVienDTO request);
    public GiangVien updateGiangVien(GiangVienDTO request, String id);
    public GiangVien getGiangVienById(String id);
    public void deleteGiangVien(String id);
}
