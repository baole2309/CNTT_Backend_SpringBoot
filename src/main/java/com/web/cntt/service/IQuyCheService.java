package com.web.cntt.service;

import com.web.cntt.dto.SinhVienDTO;
import com.web.cntt.model.QuyChe;
import com.web.cntt.model.SinhVien;

import java.util.List;

public interface IQuyCheService {
    public List<QuyChe> getAllQuyChe();
    public List<SinhVien> getSinhVienByLop(String maLop);
    public SinhVien getSinhVienById(String id);
    public SinhVien addSinhVien(SinhVienDTO request);
    public SinhVien updateSinhVien(SinhVienDTO request, String id);
    public void deleteSinhVien(String id);

}
