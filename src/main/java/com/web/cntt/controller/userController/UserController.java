package com.web.cntt.controller.userController;

import com.web.cntt.dto.UserDTO;
import com.web.cntt.model.Post;
import com.web.cntt.model.User;
import com.web.cntt.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/user/
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    @GetMapping("/infoUser")
    public ResponseEntity<UserDTO> getInfoUser(){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserDTO result = userService.getUserInfo(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
