package com.web.cntt.service.impl;

import com.web.cntt.dto.CTDaoTaoDTO;
import com.web.cntt.model.CTDaoTao;
import com.web.cntt.repository.CTDTRepository;
import com.web.cntt.service.ICTDaoTaoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CTDTService implements ICTDaoTaoService {
    private final CTDTRepository ctdtRepository;
    @Override
    public CTDaoTao addCTDaoTao(CTDaoTaoDTO request) {
        CTDaoTao ctDaoTao = new CTDaoTao();
        ctDaoTao.setId(UUID.randomUUID());
        ctDaoTao.setName(request.getName());
        ctDaoTao.setDescription(request.getDescription());
        ctDaoTao.setImage(request.getImage());
        ctDaoTao.setCreateDate(new Date(System.currentTimeMillis()));
        return ctdtRepository.save(ctDaoTao);
    }

    @Override
    public CTDaoTao updateCTDaoTao(CTDaoTaoDTO request, String id) {
        CTDaoTao ctDaoTao = ctdtRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new IllegalArgumentException("không tìm thấy"));
        ctDaoTao.setName(request.getName());
        ctDaoTao.setDescription(request.getDescription());
        ctDaoTao.setImage(request.getImage());
        ctDaoTao.setCreateDate(new Date(System.currentTimeMillis()));
        return ctdtRepository.save(ctDaoTao);
    }

    @Override
    public List<CTDaoTao> getAllCTDaoTao() {
        try {
            return ctdtRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải danh sách ctdaotao");
        }
    }

    @Override
    public CTDaoTao getNewCTDaoTao() {
        return ctdtRepository.findFirstByOrderByCreateDateDesc().orElseThrow(
                () -> new IllegalArgumentException("không tìm thấy"));
    }

    @Override
    public CTDaoTao getCTDaoTaoById(String id) {
        return ctdtRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new IllegalArgumentException("không tìm thấy"));
    }

    @Override
    public void deleteCTDaoTao(String id) {
        CTDaoTao ctDaoTao = ctdtRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new IllegalArgumentException("không tìm thấy"));
        ctdtRepository.delete(ctDaoTao);
        System.out.println("Delete success");
    }
}
