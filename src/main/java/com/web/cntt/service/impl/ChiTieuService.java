package com.web.cntt.service.impl;

import com.web.cntt.dto.ChiTieuDTO;
import com.web.cntt.model.ChiTieu;
import com.web.cntt.model.QuyChe;
import com.web.cntt.repository.ChiTieuRepository;
import com.web.cntt.service.IChiTieuService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ChiTieuService implements IChiTieuService {
    private final ChiTieuRepository chiTieuRepository;
    @Override
    public List<ChiTieu> getAllChiTieu() {
        try {
            return chiTieuRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải danh sách ctdaotao");
        }
    }

    @Override
    public ChiTieu getChiTieuById(String id) {
        return chiTieuRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy chi tiêu với :" + id));
    }

    @Override
    public ChiTieu addChiTieu(ChiTieuDTO request) {
        ChiTieu chiTieu = new ChiTieu();
        chiTieu.setId(UUID.randomUUID());
        chiTieu.setMaNganh(request.getMaNganh());
        chiTieu.setTenNganh(request.getTenNganh());
        chiTieu.setChiTieu(request.getChiTieu());
        chiTieu.setNam(request.getNam());
        chiTieu.setDiemChuan(request.getDiemChuan());
        chiTieu.setCreateBy("");
        chiTieu.setCreateDate(new Date(System.currentTimeMillis()));
        return chiTieuRepository.save(chiTieu);
    }

    @Override
    public ChiTieu updateChiTieu(ChiTieuDTO request, String id) {
        ChiTieu chiTieu = chiTieuRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy sinh viên với :" + id));
        chiTieu.setId(UUID.randomUUID());
        chiTieu.setMaNganh(request.getMaNganh());
        chiTieu.setTenNganh(request.getTenNganh());
        chiTieu.setChiTieu(request.getChiTieu());
        chiTieu.setNam(request.getNam());
        chiTieu.setDiemChuan(request.getDiemChuan());
        chiTieu.setCreateBy("");
        chiTieu.setCreateDate(new Date(System.currentTimeMillis()));
        return chiTieuRepository.save(chiTieu);
    }

    @Override
    public void deleteChiTieu(String id) {
        ChiTieu chiTieu = chiTieuRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy sinh viên với :" + id));
        chiTieuRepository.delete(chiTieu);
        System.out.println("delete success:" + id);
    }
}
