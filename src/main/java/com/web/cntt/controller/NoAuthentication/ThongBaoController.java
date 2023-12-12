package com.web.cntt.controller.NoAuthentication;

import com.web.cntt.dto.ThongBaoDTO;
import com.web.cntt.model.ThongBao;
import com.web.cntt.service.IThongBaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/product/thongBao
@RequiredArgsConstructor
public class ThongBaoController {
    private final IThongBaoService thongBaoService;
    @GetMapping("/thongBao")
    public ResponseEntity<List<ThongBao>> getAllSinhVien(){
        try {
            List<ThongBao> result = thongBaoService.getAllThongBao();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/thongBao/{id}")
    public ResponseEntity<ThongBao> getThongBaoById(@PathVariable("id") String id){
        try {
            ThongBao result = thongBaoService.getThongBaoById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @GetMapping("/thongBao/{name}")
//    public ResponseEntity<ThongBao> getThongBaoByName(@PathVariable("name") String name){
//        try {
//            ThongBao result = thongBaoService.getThongBaoByName(name);
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @DeleteMapping("/thongBao/{id}")
//    public ResponseEntity<String> deleteThongBaoById(@PathVariable("id") String id){
//        try {
//            thongBaoService.deleteThongBao(id);
//            return new ResponseEntity<>("Delete success", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping("/thongBao")
//    public ResponseEntity<ThongBao> addThongBao(@RequestBody ThongBaoDTO request){
//        try {
//            ThongBao result = thongBaoService.addThongBao(request);
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/thongBao/{id}")
//    public ResponseEntity<ThongBao> updateThongBao(@RequestBody ThongBaoDTO request, @PathVariable("id") String id){
//        try {
//            ThongBao result = thongBaoService.updateThongBao(request, id);
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
