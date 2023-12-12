package com.web.cntt.controller.userController;

import com.web.cntt.dto.PostDTO;
import com.web.cntt.model.Post;
import com.web.cntt.model.User;
import com.web.cntt.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/user/
@RequiredArgsConstructor
public class PostController {
    private final IPostService postService;

    @GetMapping("/post")
    public ResponseEntity<List<Post>> getAllPost(){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<Post> result = postService.getAllPost(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") String id){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Post result = postService.getPostById(id, user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/postByUser")
    public ResponseEntity<List<Post>> getPostByUser(){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<Post> result = postService.getPostByUser(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/topPost")
    public ResponseEntity<List<Post>> getTopPost(){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<Post> result = postService.getTopPost(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/post")
    public ResponseEntity<Post> addPost(@RequestBody PostDTO request){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Post result = postService.addPost(request, user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/post/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody PostDTO request, @PathVariable("id") String id){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Post result = postService.updatePost(request, id, user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") String id){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            postService.deletePost(id, user);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
