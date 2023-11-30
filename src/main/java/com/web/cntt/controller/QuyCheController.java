package com.web.cntt.controller;

import com.web.cntt.dto.QuyCheDTO;
import com.web.cntt.dto.SinhVienDTO;
import com.web.cntt.model.QuyChe;
import com.web.cntt.model.SinhVien;
import com.web.cntt.service.IQuyCheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/product/quyChe
@RequiredArgsConstructor
public class QuyCheController {
    private final IQuyCheService quyCheService;

    @GetMapping("/quyChe")
    public ResponseEntity<List<QuyChe>> getAllQuyChe(){
        try {
            List<QuyChe> result = quyCheService.getAllQuyChe();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/quyChe/{id}")
    public ResponseEntity<QuyChe> getQuyCheById(@PathVariable("id") String id){
        try {
            QuyChe result = quyCheService.getSQuyCheById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/quyChe/{id}")
    public ResponseEntity<String> deleteQuyChe(@PathVariable("id") String id){
        try {
            quyCheService.deleteQuyChe(id);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/quyChe{id}")
    public ResponseEntity<QuyChe> updateQuyChe(@RequestBody QuyCheDTO request, @PathVariable("id") String id){
        try {
            QuyChe result = quyCheService.updateQuyChe(request, id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/quyChe")
    public ResponseEntity<QuyChe> addQuyChe(@RequestBody QuyCheDTO request){
        try {
            QuyChe result = quyCheService.addQuyChe(request);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
