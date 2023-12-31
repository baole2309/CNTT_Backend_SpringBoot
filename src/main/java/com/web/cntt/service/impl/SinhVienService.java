package com.web.cntt.service.impl;

import com.web.cntt.dto.SinhVienDTO;
import com.web.cntt.model.Lop;
import com.web.cntt.model.SinhVien;
import com.web.cntt.repository.LopRepository;
import com.web.cntt.repository.SinhVienRepository;
import com.web.cntt.service.ISinhVienService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class SinhVienService implements ISinhVienService {
    private final SinhVienRepository sinhVienRepository;
    private final LopRepository lopRepository;
    @Override
    public List<SinhVien> getAllSinhVien() {
        try {
            return sinhVienRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải danh sách sinh viên");
        }
    }



    @Override
    public List<SinhVien> getSinhVienByLop(String maLop) {
        Lop existingLop = lopRepository.findLopByMaLop(maLop).orElseThrow(() -> new IllegalArgumentException("Not found"));
        if(existingLop != null){
            return sinhVienRepository.findSinhVienByLop(existingLop);
        }else {
            throw new RuntimeException("Không thể tìm thấy lớp");
        }
    }

    @Override
    public SinhVien getSinhVienById(String id) {
        return sinhVienRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy sinh viên với :" + id));
    }

    @Override
    public SinhVien addSinhVien(SinhVienDTO request) {
        if (request == null) {
            throw new IllegalArgumentException("Invalid request");
        }

        Lop existingLop = lopRepository.findLopByMaLop(request.getMaLop())
                .orElseThrow(() -> new EntityNotFoundException("Lop not found"));

        SinhVien sinhVien = new SinhVien();
        sinhVien.setId(UUID.randomUUID());
        sinhVien.setMaSV(request.getMaSV());
        sinhVien.setHo(request.getHo());
        sinhVien.setTen(request.getTen());
        sinhVien.setEmail(request.getEmail());
        sinhVien.setGender(request.getGender());
        sinhVien.setSchoolYear(request.getSchoolYear());
        sinhVien.setNgaySinh(request.getNgaySinh());
        sinhVien.setSdt(request.getSdt());
        sinhVien.setLop(existingLop);

        return sinhVienRepository.save(sinhVien);
    }


    @Override
    public SinhVien updateSinhVien(SinhVienDTO request, String id) {
        SinhVien sinhVien = sinhVienRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy sinh viên với :" + id));

        Lop existingLop = lopRepository.findLopByMaLop(request.getMaLop()).orElseThrow(() -> new IllegalArgumentException("Not found"));
            sinhVien.setLop(existingLop);
            sinhVien.setMaSV(request.getMaSV());
            sinhVien.setHo(request.getHo());
            sinhVien.setTen(request.getTen());
            sinhVien.setEmail(request.getEmail());
            sinhVien.setGender(request.getGender());
            sinhVien.setSchoolYear(request.getSchoolYear());
            sinhVien.setNgaySinh(request.getNgaySinh());
            sinhVien.setSdt(request.getSdt());
            sinhVien.setSdt(request.getSdt());
            return sinhVienRepository.save(sinhVien);

    }

    @Override
    public void deleteSinhVien(String id) {
        SinhVien sinhVien = sinhVienRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy sinh viên với :" + id));
        sinhVienRepository.delete(sinhVien);
        System.out.println("delete success:" + id);
    }
}
