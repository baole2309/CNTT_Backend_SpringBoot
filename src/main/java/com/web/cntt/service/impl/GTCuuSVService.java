package com.web.cntt.service.impl;

import com.web.cntt.dto.GTCuuSVDTO;
import com.web.cntt.repository.GTCuuSVRepository;
import com.web.cntt.service.IGTCuuSVService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.web.cntt.model.GTCuuSV;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class GTCuuSVService implements IGTCuuSVService {
    private final GTCuuSVRepository gtCuuSVRepository;


    @Override
    public List<GTCuuSV> getAllGTCuuSV() {
        try {
            return gtCuuSVRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải danh sách gioi thieu");
        }
    }

    @Override
    public GTCuuSV addGTCuuSV(GTCuuSVDTO request) {
        GTCuuSV gioiThieu = new GTCuuSV();
        gioiThieu.setId(UUID.randomUUID());
        gioiThieu.setAim(request.getAim());
        gioiThieu.setDescription(request.getDescription());
        gioiThieu.setTitle(request.getTitle());
        gioiThieu.setNgayTB(request.getNgayTB());
        gioiThieu.setImage(request.getImage());
        gioiThieu.setCreateBy("");
        gioiThieu.setCreateDate(new Date(System.currentTimeMillis()));
        return gtCuuSVRepository.save(gioiThieu);
    }

    @Override
    public GTCuuSV updateGTCuuSV(GTCuuSVDTO request, String id) {
        GTCuuSV gioiThieu = gtCuuSVRepository.findById(UUID.fromString(id)).orElseThrow(
                () ->new IllegalArgumentException(" không tìm thấy"));
        gioiThieu.setId(UUID.randomUUID());
        gioiThieu.setAim(request.getAim());
        gioiThieu.setDescription(request.getDescription());
        gioiThieu.setTitle(request.getTitle());
        gioiThieu.setNgayTB(request.getNgayTB());
        gioiThieu.setImage(request.getImage());
        gioiThieu.setCreateBy("");
        gioiThieu.setCreateDate(new Date(System.currentTimeMillis()));
        return gtCuuSVRepository.save(gioiThieu);
    }

    @Override
    public GTCuuSV getGTCuuSVById(String id) {
        return gtCuuSVRepository.findById(UUID.fromString(id)).orElseThrow(
                () ->new IllegalArgumentException(" không tìm thấy"));
    }

    @Override
    public void deleteGTCuuSV(String id) {
        GTCuuSV gioiThieu = gtCuuSVRepository.findById(UUID.fromString(id)).orElseThrow(
                () ->new IllegalArgumentException(" không tìm thấy"));
        gtCuuSVRepository.delete(gioiThieu);
        System.out.println("Delete success");
    }
}
