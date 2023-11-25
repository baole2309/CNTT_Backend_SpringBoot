package com.web.cntt.service;

import com.web.cntt.dto.KhoaDTO;
import com.web.cntt.dto.LopDTO;
import com.web.cntt.model.Khoa;
import com.web.cntt.model.Lop;

import java.util.List;

public interface ILopService {
    public Lop addLop(LopDTO request);
    public Lop updateLop(LopDTO request, String id);

    public List<Lop> getAllLop();
    public Lop getLopById(String id);
    public void deleteLop(String id);
}
