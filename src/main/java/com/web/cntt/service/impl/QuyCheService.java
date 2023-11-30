package com.web.cntt.service.impl;

import com.web.cntt.dto.QuyCheDTO;
import com.web.cntt.model.QuyChe;
import com.web.cntt.repository.QuyCheRepository;
import com.web.cntt.service.IQuyCheService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class QuyCheService implements IQuyCheService {
    private final QuyCheRepository quyCheRepository;
    @Override
    public List<QuyChe> getAllQuyChe() {
        try {
            return quyCheRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải danh sách sinh viên");
        }
    }

    @Override
    public QuyChe getSQuyCheById(String id) {
        return quyCheRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy quy chế với :" + id));
    }

    @Override
    public QuyChe addQuyChe(QuyCheDTO request) {
        QuyChe quyChe = new QuyChe();
        quyChe.setId(UUID.randomUUID());
        quyChe.setTenQuyChe(request.getTenQuyChe());
        quyChe.setContent(request.getContent());
        quyChe.setNgayApDung(request.getNgayApDung());
        quyChe.setCreateBy("");
        quyChe.setCreateDate(new Date(System.currentTimeMillis()));
        return quyCheRepository.save(quyChe);
    }

    @Override
    public QuyChe updateQuyChe(QuyCheDTO request, String id) {
        QuyChe quyChe = quyCheRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy sinh viên với :" + id));
        quyChe.setId(UUID.randomUUID());
        quyChe.setTenQuyChe(request.getTenQuyChe());
        quyChe.setContent(request.getContent());
        quyChe.setNgayApDung(request.getNgayApDung());
        quyChe.setCreateBy("");
        quyChe.setCreateDate(new Date(System.currentTimeMillis()));
        return quyCheRepository.save(quyChe);
    }

    @Override
    public void deleteQuyChe(String id) {
        QuyChe quyChe = quyCheRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy sinh viên với :" + id));
        quyCheRepository.delete(quyChe);
        System.out.println("delete success:" + id);
    }
}
