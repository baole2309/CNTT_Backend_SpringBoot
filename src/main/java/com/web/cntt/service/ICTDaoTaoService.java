package com.web.cntt.service;

import com.web.cntt.dto.CTDaoTaoDTO;
import com.web.cntt.dto.KhoaDTO;
import com.web.cntt.model.CTDaoTao;
import com.web.cntt.model.Khoa;

import java.util.List;

public interface ICTDaoTaoService {

    public CTDaoTao addCTDaoTao(CTDaoTaoDTO request);
    public CTDaoTao updateCTDaoTao(CTDaoTaoDTO request, String id);
    public List<CTDaoTao> getAllCTDaoTao();
    public CTDaoTao getNewCTDaoTao();
    public CTDaoTao getCTDaoTaoById(String id);
    public void deleteCTDaoTao(String id);
}
