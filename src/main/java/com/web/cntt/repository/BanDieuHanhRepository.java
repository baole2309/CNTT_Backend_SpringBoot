package com.web.cntt.repository;

import com.web.cntt.model.BanDieuHanh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BanDieuHanhRepository extends JpaRepository<BanDieuHanh, UUID> {
}
