package com.web.cntt.service.impl;

import com.web.cntt.dto.LopDTO;
import com.web.cntt.model.Lop;
import com.web.cntt.repository.LopRepository;
import com.web.cntt.service.ILopService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class LopService implements ILopService {
    private final LopRepository lopRepository;

    @Override
    public Lop addLop(LopDTO request) {
        Optional<Lop> existingLopOptional = lopRepository.findLopByMaLop(request.getMaLop());

        if (!existingLopOptional.isPresent()) {
            Lop lop = new Lop();
            lop.setId(UUID.randomUUID());
            lop.setMaLop(request.getMaLop());
            lop.setTenLop(request.getTenLop());
            lop.setNgayTL(request.getNgayTL());
            lop.setGvCoVan(request.getGvCoVan());
            lop.setTruongLop(request.getTruongLop());
            lop.setSiSo(request.getSiSo());

            return lopRepository.save(lop);
        } else {
            throw new org.springframework.dao.DuplicateKeyException("Mã lớp đã tồn tại: " + request.getMaLop());
        }
    }



    @Override
    public Lop updateLop(LopDTO request, String id) {
        Lop lop = lopRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy lớp với :" + id));
        lop.setMaLop(request.getMaLop());
        lop.setTenLop(request.getTenLop());
        lop.setNgayTL(request.getNgayTL());
        lop.setGvCoVan(request.getGvCoVan());
        lop.setTruongLop(request.getTruongLop());
        lop.setSiSo(request.getSiSo());
        return lopRepository.save(lop);
    }

    @Override
    public List<Lop> getAllLop() {
        try {
            return lopRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải list lớp");
        }
    }

    @Override
    public Lop getLopById(String id) {
        return lopRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy lớp với :" + id));
    }

    @Override
    public void deleteLop(String id) {
        Lop lop = lopRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy lớp với :" + id));
        lopRepository.delete(lop);
        System.out.println("delete success: " + id);
    }
}
