package com.web.cntt.service;

import com.web.cntt.dto.AnhNenDTO;
import com.web.cntt.model.AnhNen;

import java.util.List;

public interface IAnhNenService {
    public List<AnhNen> getAllAnhNen();
    public AnhNen getAnhNenByName(String name) throws Exception;
    public AnhNen getAnhNenById(String id);
    public AnhNen addAnhNen(AnhNenDTO request);
    public AnhNen updateAnhNen(AnhNenDTO request, String id);
    public void deleteAnhNenById(String id);
}
