package com.web.cntt.repository;

import com.web.cntt.model.GTCuuSV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GTCuuSVRepository extends JpaRepository<GTCuuSV, UUID> {
}
