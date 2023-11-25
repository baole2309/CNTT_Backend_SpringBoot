package com.web.cntt.service.impl;

import com.web.cntt.dto.GiangVienDTO;
import com.web.cntt.model.GiangVien;
import com.web.cntt.repository.GiangVienRepository;
import com.web.cntt.service.IGiangVienService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GiangVienService implements IGiangVienService {
    private final GiangVienRepository giangVienRepository;
    @Override
    public List<GiangVien> getAllGiangVien() {
        try {
            return giangVienRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải danh sách giảng viên");
        }
    }

    @Override
    public GiangVien addGiangVien(GiangVienDTO request) {
        GiangVien existingGV = giangVienRepository.findGiangVienByMaGV(request.getMaGV());
        if(existingGV != null){
            GiangVien giangVien = new GiangVien();
            //setData
            giangVien.setMaGV(request.getMaGV());
            giangVien.setHo(request.getHo());
            giangVien.setTen(request.getTen());
            giangVien.setNgayVL(request.getNgayVL());
            giangVien.setChucVu(request.getChucVu());
            giangVien.setHeSoLuong(request.getHeSoLuong());
            giangVien.setHocVi(request.getHocVi());
            giangVien.setGioiTinh(request.getGioiTinh());
            giangVien.setSdt(request.getSdt());
            giangVien.setEmail(request.getEmail());
            giangVien.setNgaySinh(request.getNgaySinh());
            return giangVienRepository.save(giangVien);
        }else {
            throw new DuplicateKeyException("Mã GV đã tồn tại: " + request.getMaGV());
        }
    }

    @Override
    public GiangVien updateGiangVien(GiangVienDTO request, String id) {
        GiangVien giangVien = giangVienRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("không thể tìm thấy giang viên với id: " +id));
        //set data
        giangVien.setMaGV(request.getMaGV());
        giangVien.setHo(request.getHo());
        giangVien.setTen(request.getTen());
        giangVien.setNgayVL(request.getNgayVL());
        giangVien.setChucVu(request.getChucVu());
        giangVien.setHeSoLuong(request.getHeSoLuong());
        giangVien.setHocVi(request.getHocVi());
        giangVien.setGioiTinh(request.getGioiTinh());
        giangVien.setSdt(request.getSdt());
        giangVien.setEmail(request.getEmail());
        giangVien.setNgaySinh(request.getNgaySinh());
        return giangVienRepository.save(giangVien);
    }

    @Override
    public GiangVien getGiangVienById(String id) {
        return giangVienRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("không thể tìm thấy giang viên với id: " +id));
    }

    @Override
    public void deleteGiangVien(String id) {
        GiangVien giangVien = giangVienRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("không thể tìm thấy giang viên với id: " +id));
        giangVienRepository.delete(giangVien);
        System.out.println("Delete success: " + id);
    }
}
