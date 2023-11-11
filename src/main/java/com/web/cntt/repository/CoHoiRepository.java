package com.web.cntt.repository;

import com.web.cntt.model.CoHoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CoHoiRepository extends JpaRepository<CoHoi, UUID> {
}
