package com.web.cntt.controller;

import com.web.cntt.dto.SinhVienDTO;
import com.web.cntt.model.Lop;
import com.web.cntt.model.SinhVien;
import com.web.cntt.service.ISinhVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
//@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/product/sinhVien
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

    @GetMapping("/sinhVien{id}")
    public ResponseEntity<SinhVien> getSinhVienById(@PathVariable("id") String id){
        try {
            SinhVien result = sinhVienService.getSinhVienById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sinhVien{id}")
    public ResponseEntity<List<SinhVien>> getSinhVienByLop(@PathVariable("id") String id){
        try {
            List<SinhVien> result = sinhVienService.getSinhVienByLop(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/sinhVien{id}")
    public ResponseEntity<String> deleteSinhVien(@PathVariable("id") String id){
        try {
            sinhVienService.deleteSinhVien(id);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/sinhVien{id}")
    public ResponseEntity<SinhVien> updateSinhVien(@RequestParam SinhVienDTO request, @PathVariable("id") String id){
        try {
            SinhVien result = sinhVienService.updateSinhVien(request, id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/sinhVien")
    public ResponseEntity<SinhVien> addSinhVien(SinhVienDTO request){
        try {
            SinhVien result = sinhVienService.addSinhVien(request);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
