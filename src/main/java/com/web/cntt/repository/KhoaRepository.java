package com.web.cntt.repository;

import com.web.cntt.model.Khoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, UUID> {

    Optional<Khoa> findFirstByOrderByCreateDateDesc();
}
