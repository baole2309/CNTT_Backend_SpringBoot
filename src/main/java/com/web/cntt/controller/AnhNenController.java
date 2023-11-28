package com.web.cntt.controller;

import com.web.cntt.dto.AnhNenDTO;
import com.web.cntt.model.AnhNen;
import com.web.cntt.service.IAnhNenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
//@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/product/anhNen
@RequiredArgsConstructor
public class AnhNenController {
    private final IAnhNenService anhNenService;
    @GetMapping("/anhNen")
    public ResponseEntity<List<AnhNen>> getAllAnhNen(){
        try {
            List<AnhNen> result = anhNenService.getAllAnhNen();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping ("/anhNen{id}")
    public ResponseEntity<AnhNen> getAnhNenById(@PathVariable("id") String id) {

        try {
            AnhNen result = anhNenService.getAnhNenById(id);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/anhNen{name}")
    public ResponseEntity<AnhNen> getAnhNenByName(@PathVariable("name") String name){
        try {
            AnhNen result = anhNenService.getAnhNenByName(name);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/anhNen")
    public ResponseEntity<AnhNen> addBanDH(AnhNenDTO request) {

        try {
            AnhNen result = anhNenService.addAnhNen(request);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping ("/anhNen{id}")
    public ResponseEntity<AnhNen> updateBanDH(@RequestParam AnhNenDTO request, @PathVariable("id") String id) {

        try {
            AnhNen result = anhNenService.updateAnhNen(request, id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/anhNen{id}")
    public ResponseEntity<String> deleteAnhNen(@PathVariable("id") String id) {

        try {
            anhNenService.deleteAnhNenById(id);

            return new ResponseEntity<>("delete success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
