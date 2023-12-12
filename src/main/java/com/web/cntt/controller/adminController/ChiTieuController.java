package com.web.cntt.controller.adminController;

import com.web.cntt.dto.ChiTieuDTO;
import com.web.cntt.model.ChiTieu;
import com.web.cntt.service.IChiTieuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/admin/user
@RequiredArgsConstructor
@Component("adminChiTieuController")
public class ChiTieuController {
    private final IChiTieuService chiTieuService;

    @GetMapping("/chiTieu")
    public ResponseEntity<List<ChiTieu>> getAllChiTieu(){
        try {
            List<ChiTieu> result = chiTieuService.getAllChiTieu();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/chiTieu/{id}")
    public ResponseEntity<ChiTieu> getChiTieuById(@PathVariable("id") String id){
        try {
            ChiTieu result = chiTieuService.getChiTieuById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/chiTieu")
    public ResponseEntity<ChiTieu> addChiTieu(@RequestBody ChiTieuDTO request){
        try {
            ChiTieu result = chiTieuService.addChiTieu(request);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/chiTieu/{id}")
    public ResponseEntity<ChiTieu> updateChiTieu(@RequestBody ChiTieuDTO request, @PathVariable("id") String id){
        try {
            ChiTieu result = chiTieuService.updateChiTieu(request, id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/chiTieu/{id}")
    public ResponseEntity<String> deleteChiTieuById(@PathVariable("id") String id){
        try {
            chiTieuService.deleteChiTieu(id);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
