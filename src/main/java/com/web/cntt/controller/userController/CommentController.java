package com.web.cntt.controller.userController;

import com.web.cntt.dto.CommentDTO;
import com.web.cntt.model.Comment;
import com.web.cntt.model.User;
import com.web.cntt.service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://localhost:3000"})
//http://localhost:8080/api/user/comment
@RequiredArgsConstructor
public class CommentController {
    private final ICommentService commentService;

    @GetMapping("/comment")
    public ResponseEntity<List<Comment>> getAllPost(){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<Comment> result = commentService.getAllComment(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/commentByUser")
    public ResponseEntity<List<Comment>> getCommentByUser(){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<Comment> result = commentService.getCommentByUser(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/comment/{id}")
    public ResponseEntity<Comment> addComment(@RequestBody CommentDTO request, @PathVariable("id") String id){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Comment result = commentService.addComment(request, id, user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/comment/{id}")
    public ResponseEntity<Comment> updateComment(@RequestBody CommentDTO request, @PathVariable("id") String id){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Comment result = commentService.updateComment(request, id, user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/comment/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") String id){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            commentService.deleteComment(id, user);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
