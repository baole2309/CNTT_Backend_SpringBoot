package com.web.cntt.service;

import com.web.cntt.dto.ThongBaoDTO;
import com.web.cntt.model.ThongBao;
import com.web.cntt.service.impl.ThongBaoService;

import java.util.List;

public interface IThongBaoService {
    public List<ThongBao> getAllThongBao();
    public ThongBao getThongBaoById(String id);
    public ThongBao getThongBaoByName(String name);
    public ThongBao addThongBao(ThongBaoDTO request);
    public ThongBao updateThongBao(ThongBaoDTO request, String id);
    public void deleteThongBao(String id);
}
