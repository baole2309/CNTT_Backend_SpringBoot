package com.web.cntt.service.impl;

import com.web.cntt.dto.AnhNenDTO;
import com.web.cntt.model.AnhNen;
import com.web.cntt.repository.AnhNenRepository;
import com.web.cntt.service.IAnhNenService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class AnhNenService implements IAnhNenService {
    private final AnhNenRepository anhNenRepository;
    @Override
    public List<AnhNen> getAllAnhNen() {
        try {
            return anhNenRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải danh sách ảnh nền");
        }
    }

    @Override
    public AnhNen getAnhNenByName(String name) throws Exception {
        AnhNen anhNen = anhNenRepository.findAnhNenByName(name);
        if(anhNen != null){
            return anhNen;
        }else {
            throw new Exception("không tìm thấy anh nền");
        }
    }

    @Override
    public AnhNen getAnhNenById(String id) {
        return anhNenRepository.findById(UUID.fromString(id)).orElseThrow(
                () ->new IllegalArgumentException("not found"));
    }

    @Override
    public AnhNen addAnhNen(AnhNenDTO request) {
        AnhNen anhNen = new AnhNen();
        anhNen.setName(request.getName());
        anhNen.setDescription(request.getDescription());
        anhNen.setResource(request.getResource());
        anhNen.setCreateDate(new Date(System.currentTimeMillis()));
        return anhNenRepository.save(anhNen);
    }

    @Override
    public AnhNen updateAnhNen(AnhNenDTO request, String id) {
        AnhNen anhNen = anhNenRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new IllegalArgumentException("không tìm thấy"));
        anhNen.setName(request.getName());
        anhNen.setDescription(request.getDescription());
        anhNen.setResource(request.getResource());
        anhNen.setModifiedDate(new Date(System.currentTimeMillis()));
        return anhNenRepository.save(anhNen);
    }

    @Override
    public void deleteAnhNenById(String id) {
        AnhNen anhNen = anhNenRepository.findById(UUID.fromString(id)).orElseThrow(
                () ->new IllegalArgumentException("not found"));
        anhNenRepository.delete(anhNen);
        System.out.println("delete success");
    }

}
