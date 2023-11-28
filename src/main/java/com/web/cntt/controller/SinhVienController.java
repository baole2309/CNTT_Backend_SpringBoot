package com.web.cntt.controller;

import com.web.cntt.model.Lop;
import com.web.cntt.model.SinhVien;
import com.web.cntt.service.ISinhVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
//@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/product/lop
@RequiredArgsConstructor
public class SinhVienController {
    private final ISinhVienService sinhVienService;

    @GetMapping("/sinhVien")
    public ResponseEntity<List<SinhVien>> getAllSinhVien(){
        try {
            List<SinhVien> result = sinhVienService.getAllSinhVien();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
