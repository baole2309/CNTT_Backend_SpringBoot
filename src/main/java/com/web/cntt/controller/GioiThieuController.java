package com.web.cntt.controller;

import com.web.cntt.dto.GioiThieuDTO;
import com.web.cntt.model.GioiThieu;
import com.web.cntt.service.IGioiThieuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
//@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/product/gioiThieu
@RequiredArgsConstructor
public class GioiThieuController {
    private final IGioiThieuService gioiThieuService;
    @GetMapping("/gioiThieu")
    public ResponseEntity<List<GioiThieu>> getAllGioiThieu(){
        try {
            List<GioiThieu> result = gioiThieuService.getAllGioiThieu();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping ("/gioiThieu{id}")
    public ResponseEntity<GioiThieu> getGioiThieuById(@PathVariable("id") String id) {

        try {
            GioiThieu result = gioiThieuService.getGioiThieuById(id);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/gioiThieu")
    public ResponseEntity<GioiThieu> addGioiThieu(GioiThieuDTO request) {

        try {
            GioiThieu result = gioiThieuService.addGioiThieu(request);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping ("/gioiThieu{id}")
    public ResponseEntity<GioiThieu> updateGioiThieu(@RequestParam GioiThieuDTO request, @PathVariable("id") String id) {

        try {
            GioiThieu result = gioiThieuService.updateGioiThieu(request, id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/gioiThieu{id}")
    public ResponseEntity<String> deleteGioiThieu(@PathVariable("id") String id) {

        try {
            gioiThieuService.deleteGioiThieu(id);

            return new ResponseEntity<>("delete success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
