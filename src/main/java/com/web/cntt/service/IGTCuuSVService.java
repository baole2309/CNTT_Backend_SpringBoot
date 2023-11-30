package com.web.cntt.service;

import com.web.cntt.dto.GTCuuSVDTO;
import com.web.cntt.model.GTCuuSV;

import java.util.List;

public interface IGTCuuSVService {
    public List<GTCuuSV> getAllGTCuuSV();
    public GTCuuSV addGTCuuSV(GTCuuSVDTO request);
    public GTCuuSV updateGTCuuSV(GTCuuSVDTO request, String id);
    public GTCuuSV getGTCuuSVById(String id);
    public void deleteGTCuuSV(String id);
}
