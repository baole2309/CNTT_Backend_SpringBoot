package com.web.cntt.repository;

import com.web.cntt.model.CuuSinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuuSVRepository extends JpaRepository<CuuSinhVien,String> {
}
