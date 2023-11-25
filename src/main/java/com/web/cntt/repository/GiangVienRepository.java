package com.web.cntt.repository;

import com.web.cntt.model.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien,String> {
    public GiangVien findGiangVienByMaGV(String maGV);
}
