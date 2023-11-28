package com.web.cntt.repository;

import com.web.cntt.model.CTDaoTao;
import com.web.cntt.model.Khoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CTDTRepository extends JpaRepository<CTDaoTao, UUID> {
    Optional<CTDaoTao> findFirstByOrderByCreateDateDesc();
}
