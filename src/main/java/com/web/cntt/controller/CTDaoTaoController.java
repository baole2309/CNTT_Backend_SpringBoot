package com.web.cntt.controller;

import com.web.cntt.dto.CTDaoTaoDTO;
import com.web.cntt.model.CTDaoTao;
import com.web.cntt.service.ICTDaoTaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/product/ctDaoTao
@RequiredArgsConstructor
public class CTDaoTaoController {
    private final ICTDaoTaoService ctDaoTaoService;
    @GetMapping("/ctDaoTao")
    public ResponseEntity<List<CTDaoTao>> getAllCTDaoTao(){
        try {
            List<CTDaoTao> result = ctDaoTaoService.getAllCTDaoTao();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/ctDaoTao/{id}")
    public ResponseEntity<CTDaoTao> getThongBaoById(@PathVariable("id") String id){
        try {
            CTDaoTao result = ctDaoTaoService.getCTDaoTaoById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/newCTDaoTao")
    public ResponseEntity<CTDaoTao> getNewCTDaoTao(){
        try {
            CTDaoTao result = ctDaoTaoService.getNewCTDaoTao();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/ctDaoTao")
    public ResponseEntity<CTDaoTao> addThongBao(@RequestBody CTDaoTaoDTO request){
        try {
            CTDaoTao result = ctDaoTaoService.addCTDaoTao(request);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ctDaoTao/{id}")
    public ResponseEntity<CTDaoTao> updateThongBao(@RequestBody CTDaoTaoDTO request, @PathVariable("id") String id){
        try {
            CTDaoTao result = ctDaoTaoService.updateCTDaoTao(request, id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/ctDaoTao/{id}")
    public ResponseEntity<String> deleteCTDaoTaoById(@PathVariable("id") String id){
        try {
            ctDaoTaoService.deleteCTDaoTao(id);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
