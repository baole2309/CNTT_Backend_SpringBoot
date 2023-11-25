package com.web.cntt.repository;

import com.web.cntt.model.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LopRepository extends JpaRepository<Lop,String> {
    public Lop findLopByMaLop(String maLop);
}
