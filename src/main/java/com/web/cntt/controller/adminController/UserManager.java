package com.web.cntt.controller.adminController;

import com.web.cntt.model.Comment;
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
@RequestMapping("/api/admin")
@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/admin/user
@RequiredArgsConstructor
public class UserManager {
    private final IUserService userService;
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser(){

        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<User> result = userService.getAllAccount();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
