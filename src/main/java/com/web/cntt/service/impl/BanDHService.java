package com.web.cntt.service.impl;

import com.web.cntt.dto.BanDieuHanhDTO;
import com.web.cntt.dto.PagingDTO;
import com.web.cntt.model.BanDieuHanh;
import com.web.cntt.repository.BanDieuHanhRepository;
import com.web.cntt.service.IBanDHService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class BanDHService implements IBanDHService {
    private final BanDieuHanhRepository banDieuHanhRepository;
    @Override
    public List<BanDieuHanh> getAllBanDH() {
        try {
            return banDieuHanhRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải danh sách ban điều hành");
        }
    }

    @Override
    public BanDieuHanh getBanDieuHanhById(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return banDieuHanhRepository.findById(uuid).orElseThrow(
                    () -> new IllegalArgumentException("không tìm thấy"));
            // Tiếp tục xử lý
        } catch (IllegalArgumentException e) {
            // Xử lý ngoại lệ chuyển đổi không thành công
            throw new IllegalArgumentException("ID không hợp lệ", e);
        }

    }

    @Override
    public BanDieuHanh addBanDH(BanDieuHanhDTO request) {
        BanDieuHanh banDieuHanh = new BanDieuHanh();
        banDieuHanh.setId(UUID.randomUUID());
        banDieuHanh.setLastName(request.getLastName());
        banDieuHanh.setFirstName(request.getFirstName());
        banDieuHanh.setDescription(request.getDescription());
        banDieuHanh.setEmail(request.getEmail());
        banDieuHanh.setChucVu(request.getChucVu());
        banDieuHanh.setImage(request.getImage());
        banDieuHanh.setPhoneNumber(request.getPhoneNumber());
        banDieuHanh.setCreateBy("admin");
        banDieuHanh.setModifiedBy("");
        banDieuHanh.setCreateDate(new Date(System.currentTimeMillis()));
        return banDieuHanhRepository.save(banDieuHanh);
    }

    @Override
    public BanDieuHanh updateBanDH(BanDieuHanhDTO request, String id) {
        BanDieuHanh banDieuHanh = banDieuHanhRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new IllegalArgumentException("không tìm thấy"));

        banDieuHanh.setLastName(request.getLastName());
        banDieuHanh.setFirstName(request.getFirstName());
        banDieuHanh.setDescription(request.getDescription());
        banDieuHanh.setEmail(request.getEmail());
        banDieuHanh.setChucVu(request.getChucVu());
        banDieuHanh.setImage(request.getImage());
        banDieuHanh.setPhoneNumber(request.getPhoneNumber());
        banDieuHanh.setCreateDate(new Date(System.currentTimeMillis()));
        return banDieuHanhRepository.save(banDieuHanh);
    }

    @Override
    public void deleteBanDH(String id) {
        BanDieuHanh banDieuHanh = banDieuHanhRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new IllegalArgumentException("không tìm thấy"));
        banDieuHanhRepository.delete(banDieuHanh);
        System.out.println("Delete success");
    }
}
