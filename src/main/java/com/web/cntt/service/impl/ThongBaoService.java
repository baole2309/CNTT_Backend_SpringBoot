package com.web.cntt.service.impl;

import com.web.cntt.dto.ThongBaoDTO;
import com.web.cntt.model.ThongBao;
import com.web.cntt.repository.ThongBaoRepository;
import com.web.cntt.service.IThongBaoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ThongBaoService implements IThongBaoService {
    private final ThongBaoRepository thongBaoRepository;
    @Override
    public List<ThongBao> getAllThongBao() {
        try {
            return thongBaoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải danh sách ảnh nền");
        }
    }

    @Override
    public ThongBao getThongBaoById(String id) {
        return thongBaoRepository.findById(UUID.fromString(id)).orElseThrow(
                () ->new IllegalArgumentException(" không tìm thấy"));
    }

    @Override
    public ThongBao getThongBaoByName(String name) {
        return thongBaoRepository.findThongBaoByTitle(name).orElseThrow(
                () -> new IllegalArgumentException("không tìm thấy"));
    }

    @Override
    public ThongBao addThongBao(ThongBaoDTO request) {
        ThongBao thongBao = new ThongBao();
        thongBao.setTitle(request.getTitle());
        thongBao.setContent(request.getContent());
        thongBao.setTime(request.getTime());
        thongBao.setCreateDate(new Date(System.currentTimeMillis()));
        return thongBaoRepository.save(thongBao);
    }

    @Override
    public ThongBao updateThongBao(ThongBaoDTO request, String id) {
        ThongBao thongBao = thongBaoRepository.findById(UUID.fromString(id)).orElseThrow(
                () ->new IllegalArgumentException(" không tìm thấy"));
        if(thongBao != null){
            thongBao.setTitle(request.getTitle());
            thongBao.setContent(request.getContent());
            thongBao.setTime(request.getTime());
            thongBao.setModifiedDate(new Date(System.currentTimeMillis()));
            return thongBaoRepository.save(thongBao);
        }else {
            throw new RuntimeException("không thể update");
        }
    }

    @Override
    public void deleteThongBao(String id) {
        ThongBao thongBao = thongBaoRepository.findById(UUID.fromString(id)).orElseThrow(
                () ->new IllegalArgumentException(" không tìm thấy"));
        thongBaoRepository.delete(thongBao);
        System.out.println("Delete success");
    }
}
