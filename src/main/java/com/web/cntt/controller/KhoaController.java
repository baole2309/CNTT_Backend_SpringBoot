package com.web.cntt.controller;

import com.web.cntt.dto.KhoaDTO;
import com.web.cntt.model.Khoa;
import com.web.cntt.service.IKhoaService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
//@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/product/khoa
@RequiredArgsConstructor
public class KhoaController {
    private final IKhoaService khoaService;

    @GetMapping("/khoa")
    public ResponseEntity<List<Khoa>> getAllKhoa(){
        try {
            List<Khoa> result = khoaService.getAllKhoa();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/newKhoa")
    public ResponseEntity<Khoa> getNewKhoa(){
        try {
            Khoa result = khoaService.getNewKhoa();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping ("/khoa{id}")
    public ResponseEntity<Khoa> getKhoaById(@RequestParam String id) {

        try {
            Khoa khoa = khoaService.getKhoaById(id);

            return new ResponseEntity<>(khoa, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/khoa")
    public ResponseEntity<Khoa> addKhoa(KhoaDTO request) {

        try {
            Khoa result = khoaService.addKhoa(request);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/khoa")
    public ResponseEntity<Khoa> updateKhoa(@RequestParam KhoaDTO request, @RequestParam String id) {

        try {
            Khoa result = khoaService.updateKhoa(request, id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/khoa")
    public ResponseEntity<String> deleteKhoa(@RequestParam String id) {

        try {
            khoaService.deleteKhoa(id);

            return new ResponseEntity<>("delete success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
