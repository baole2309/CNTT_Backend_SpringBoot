package com.web.cntt.repository;

import com.web.cntt.dto.ThongBaoDTO;
import com.web.cntt.model.ThongBao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ThongBaoRepository extends JpaRepository<ThongBao, UUID> {
    public Optional<ThongBao> findThongBaoByTitle(String title);
}
