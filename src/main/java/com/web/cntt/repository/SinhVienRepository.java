package com.web.cntt.repository;

import com.web.cntt.model.Lop;
import com.web.cntt.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, UUID> {
    public List<SinhVien> findSinhVienByLop(Lop lop);
}
