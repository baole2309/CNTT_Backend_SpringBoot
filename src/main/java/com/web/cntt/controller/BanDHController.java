package com.web.cntt.controller;

import com.web.cntt.dto.BanDieuHanhDTO;
import com.web.cntt.model.BanDieuHanh;
import com.web.cntt.service.IBanDHService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/product/banDH
@RequiredArgsConstructor
public class BanDHController {
    private final IBanDHService banDHService;
    @GetMapping("/banDH")
    public ResponseEntity<List<BanDieuHanh>> getAllBanDH(){
        try {
            List<BanDieuHanh> result = banDHService.getAllBanDH();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping ("/banDH/{id}")
    public ResponseEntity<BanDieuHanh> getBanDHById(@PathVariable("id") String id) {

        try {
            BanDieuHanh result = banDHService.getBanDieuHanhById(id);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/banDH")
    public ResponseEntity<BanDieuHanh> addBanDH(@RequestBody BanDieuHanhDTO request) {

        try {
            BanDieuHanh result = banDHService.addBanDH(request);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping ("/banDH/{id}")
    public ResponseEntity<BanDieuHanh> updateBanDH(@RequestBody BanDieuHanhDTO request, @PathVariable("id") String id) {

        try {
            BanDieuHanh result = banDHService.updateBanDH(request, id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/banDH/{id}")
    public ResponseEntity<String> deleteBanDH(@PathVariable("id") String id) {

        try {
            banDHService.deleteBanDH(id);

            return new ResponseEntity<>("delete success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
