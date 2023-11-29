package com.web.cntt.controller;

import com.web.cntt.dto.LopDTO;
import com.web.cntt.model.Lop;
import com.web.cntt.service.ILopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
//@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/product/lop
@RequiredArgsConstructor
public class LopController {
    private final ILopService lopService;

    @GetMapping("/lop")
    public ResponseEntity<List<Lop>> getAllLop(){
        try {
            List<Lop> result = lopService.getAllLop();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/lop/{id}")
    public ResponseEntity<Lop> getLopById(@PathVariable("id") String id){
        try {
            Lop result = lopService.getLopById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/lop")
    public ResponseEntity<Lop> addLop(@RequestBody LopDTO request){
        try {
            Lop result = lopService.addLop(request);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/lop/{id}")
    public ResponseEntity<Lop> updateLop(@RequestBody LopDTO request, @PathVariable("id") String id){
        try {
            Lop result = lopService.updateLop(request, id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/lop/{id}")
    public ResponseEntity<String> deleteLopById(@PathVariable("id") String id){
        try {
            lopService.deleteLop(id);
            return new ResponseEntity<>("delect success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
