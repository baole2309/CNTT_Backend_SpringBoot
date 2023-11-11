package com.web.cntt.repository;

import com.web.cntt.model.GioiThieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface GioiThieuRepository extends JpaRepository<GioiThieu, UUID> {
}
