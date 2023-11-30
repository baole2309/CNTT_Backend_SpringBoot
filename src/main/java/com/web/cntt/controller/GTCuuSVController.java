package com.web.cntt.controller;

import com.web.cntt.dto.GTCuuSVDTO;
import com.web.cntt.model.GTCuuSV;
import com.web.cntt.service.IGTCuuSVService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/product/gtCuuSV
@RequiredArgsConstructor
public class GTCuuSVController {
    private final IGTCuuSVService gtCuuSVService;
    @GetMapping("/gtCuuSV")
    public ResponseEntity<List<GTCuuSV>> getAllGTCuuSV(){
        try {
            List<GTCuuSV> result = gtCuuSVService.getAllGTCuuSV();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping ("/gtCuuSV/{id}")
    public ResponseEntity<GTCuuSV> getGTCuuSVById(@PathVariable("id") String id) {

        try {
            GTCuuSV result = gtCuuSVService.getGTCuuSVById(id);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/gtCuuSV")
    public ResponseEntity<GTCuuSV> addGTCuuSV(GTCuuSVDTO request) {

        try {
            GTCuuSV result = gtCuuSVService.addGTCuuSV(request);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping ("/gtCuuSV/{id}")
    public ResponseEntity<GTCuuSV> updateGTCuuSV(@RequestParam GTCuuSVDTO request, @PathVariable("id") String id) {

        try {
            GTCuuSV result = gtCuuSVService.updateGTCuuSV(request, id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/gtCuuSV/{id}")
    public ResponseEntity<String> deleteGTCuuSV(@PathVariable("id") String id) {

        try {
            gtCuuSVService.deleteGTCuuSV(id);

            return new ResponseEntity<>("delete success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
