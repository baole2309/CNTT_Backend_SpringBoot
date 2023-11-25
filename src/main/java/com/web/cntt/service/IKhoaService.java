package com.web.cntt.service;

import com.web.cntt.dto.KhoaDTO;
import com.web.cntt.model.Khoa;

import java.util.List;

public interface IKhoaService {
    public Khoa addKhoa(KhoaDTO khoa);
    public Khoa updateKhoa(KhoaDTO khoa, String id);

    public List<Khoa> getAllKhoa();
    public Khoa getKhoaById(String id);
    public void deleteKhoa(String id);
}
