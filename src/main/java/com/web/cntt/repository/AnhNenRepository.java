package com.web.cntt.repository;

import com.web.cntt.model.AnhNen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AnhNenRepository extends JpaRepository<AnhNen, UUID> {
    public AnhNen findAnhNenByName(String name);
}
