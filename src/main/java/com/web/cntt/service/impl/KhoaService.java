package com.web.cntt.service.impl;

import com.web.cntt.dto.KhoaDTO;
import com.web.cntt.model.Khoa;
import com.web.cntt.repository.KhoaRepository;
import com.web.cntt.service.IKhoaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class KhoaService implements IKhoaService {
    private final KhoaRepository khoaRepository;

    @Override
    public Khoa addKhoa(KhoaDTO request) {
        Khoa khoa = new Khoa();
        khoa.setMaKhoa(request.getMaKhoa());
        khoa.setTenKhoa(request.getTenKhoa());
        khoa.setNgayThanhLap(request.getNgayTL());
        khoa.setTruongKhoa(request.getTruongKhoa());
        return khoaRepository.save(khoa);
    }

    @Override
    public Khoa updateKhoa(KhoaDTO request, String id) {
        Khoa khoa = khoaRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy Khoa với ID: " + id));

        khoa.setMaKhoa(request.getMaKhoa());
        khoa.setTenKhoa(request.getTenKhoa());
        khoa.setNgayThanhLap(request.getNgayTL());
        khoa.setTruongKhoa(request.getTruongKhoa());
        return khoaRepository.save(khoa);
    }

    @Override
    public List<Khoa> getAllKhoa() {
        try {
            return khoaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải list khoa");
        }
    }

    @Override
    public Khoa getNewKhoa() {
            return khoaRepository.findFirstByOrderByCreateDateDesc().orElseThrow(
                    () ->new IllegalArgumentException("Not found"));
    }


    @Override
    public Khoa getKhoaById(String id) {
       return khoaRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy Khoa với ID: " + id));
    }

    @Override
    public void deleteKhoa(String id) {
        Khoa khoa =  khoaRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy Khoa với ID: " + id));
        khoaRepository.delete(khoa);
        System.out.println("Delete success: " + id);
    }

}
