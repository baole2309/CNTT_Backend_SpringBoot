package com.web.cntt.service;

import com.web.cntt.dto.AuthenticatedReq;
import com.web.cntt.dto.AuthenticatedResp;
import com.web.cntt.dto.RegisterReq;
import com.web.cntt.model.Role;
import com.web.cntt.model.User;
import com.web.cntt.repository.UserRepository;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticatedResp register(RegisterReq req){
        var user = User.builder()
                .id(UUID.randomUUID())
                .firstName(req.getLastName())
                .lastName(req.getLastName())
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticatedResp.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticatedResp authenticate(AuthenticatedReq req){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                req.getEmail(), req.getPassword()));
        var user = userRepository.findByEmail(req.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return  AuthenticatedResp.builder()
                .token(jwtToken)
                .build();

    }
}
