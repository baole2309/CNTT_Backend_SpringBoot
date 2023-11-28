package com.web.cntt.service.impl;

import com.web.cntt.dto.GioiThieuDTO;
import com.web.cntt.model.GioiThieu;
import com.web.cntt.repository.GioiThieuRepository;
import com.web.cntt.service.IGioiThieuService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class GioiThieuService implements IGioiThieuService {
    private final GioiThieuRepository gioiThieuRepository;
    @Override
    public List<GioiThieu> getAllGioiThieu() {
        try {
            return gioiThieuRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải danh sách gioi thieu");
        }
    }

    @Override
    public GioiThieu addGioiThieu(GioiThieuDTO request) {
        GioiThieu gioiThieu = new GioiThieu();
        gioiThieu.setTongQuan(request.getTongQuan());
        gioiThieu.setCTrDaoTao(request.getCTrDaoTao());
        gioiThieu.setCoSoVatChat(request.getCoSoVatChat());
        gioiThieu.setCreateDate(new Date(System.currentTimeMillis()));
        return gioiThieuRepository.save(gioiThieu);
    }

    @Override
    public GioiThieu updateGioiThieu(GioiThieuDTO request, String id) {

        GioiThieu gioiThieu = gioiThieuRepository.findById(UUID.fromString(id)).orElseThrow(
                () ->new IllegalArgumentException(" không tìm thấy"));
        gioiThieu.setTongQuan(request.getTongQuan());
        gioiThieu.setCTrDaoTao(request.getCTrDaoTao());
        gioiThieu.setCoSoVatChat(request.getCoSoVatChat());
        gioiThieu.setCreateDate(new Date(System.currentTimeMillis()));
        return gioiThieuRepository.save(gioiThieu);
    }

    @Override
    public GioiThieu getGioiThieuById(String id) {
        return gioiThieuRepository.findById(UUID.fromString(id)).orElseThrow(
                () ->new IllegalArgumentException(" không tìm thấy"));
    }

    @Override
    public void deleteGioiThieu(String id) {
        GioiThieu gioiThieu = gioiThieuRepository.findById(UUID.fromString(id)).orElseThrow(
                () ->new IllegalArgumentException(" không tìm thấy"));
        gioiThieuRepository.delete(gioiThieu);
        System.out.println("Delete success");
    }
}
