package com.web.cntt.controller.NoAuthentication;

import com.web.cntt.dto.GiangVienDTO;
import com.web.cntt.model.GiangVien;
import com.web.cntt.service.IGiangVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/product/giangVien
@RequiredArgsConstructor
public class GiangVienController {
    private final IGiangVienService giangVienService;
    @GetMapping("/giangVien")
    public ResponseEntity<List<GiangVien>> getAllSinhVien(){
        try {
            List<GiangVien> result = giangVienService.getAllGiangVien();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping ("/giangVien/{id}")
    public ResponseEntity<GiangVien> getKhoaById(@PathVariable("id") String id) {

        try {
            GiangVien result = giangVienService.getGiangVienById(id);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @PostMapping("/giangVien")
//    public ResponseEntity<GiangVien> addGiangVien(@RequestBody GiangVienDTO request) {
//
//        try {
//            GiangVien result = giangVienService.addGiangVien(request);
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping ("/giangVien/{id}")
//    public ResponseEntity<GiangVien> updateGiangVien(@RequestBody GiangVienDTO request, @PathVariable("id") String id) {
//
//        try {
//            GiangVien result = giangVienService.updateGiangVien(request, id);
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @DeleteMapping("/giangVien/{id}")
//    public ResponseEntity<String> deleteKhoa(@PathVariable("id") String id) {
//
//        try {
//            giangVienService.deleteGiangVien(id);
//
//            return new ResponseEntity<>("delete success", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
