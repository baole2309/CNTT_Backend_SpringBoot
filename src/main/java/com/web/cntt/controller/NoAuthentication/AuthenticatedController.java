package com.web.cntt.controller.NoAuthentication;

import com.web.cntt.dto.AuthenticatedReq;
import com.web.cntt.dto.AuthenticatedResp;
import com.web.cntt.dto.RegisterReq;
import com.web.cntt.model.BanDieuHanh;
import com.web.cntt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/auth
@RequiredArgsConstructor
public class AuthenticatedController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticatedResp>register(@RequestBody RegisterReq req){
        try {
            AuthenticatedResp result = authenticationService.register(req);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticatedResp>authenticate(@RequestBody AuthenticatedReq req){
        try {
            AuthenticatedResp result = authenticationService.authenticate(req);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
