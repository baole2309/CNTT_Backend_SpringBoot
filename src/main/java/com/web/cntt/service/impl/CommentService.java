package com.web.cntt.service.impl;

import com.web.cntt.dto.CommentDTO;
import com.web.cntt.model.Comment;
import com.web.cntt.model.Post;
import com.web.cntt.model.User;
import com.web.cntt.repository.CommentRepository;
import com.web.cntt.repository.PostRepository;
import com.web.cntt.service.ICommentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService implements ICommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public List<Comment> getAllComment(User user) {
        try {
            return commentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải list lớp");
        }
    }

    @Override
    public Comment getCommentById(String id, User user) {
        return null;
    }

    @Override
    public List<Comment> getCommentByPost(String postId, User user) {
        return null;
    }

    @Override
    public List<Comment> getCommentByUser(User user) {
        try {
            return commentRepository.findCommentsByUser(user);
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải list lớp");
        }
    }

    @Override
    public Comment addComment(CommentDTO request,String postId, User user) {
        try {
            UUID postUUID = UUID.fromString(postId);
            Post post = postRepository.findById(postUUID)
                    .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + postUUID));
            Comment comment = new Comment();
            comment.setId(UUID.randomUUID());
            comment.setUser(user);
            comment.setNoiDung(request.getNoiDung());
            comment.setCreateBy(user.getFirstName());
            comment.setPost(post);
            comment.setCreateDate(new Date(System.currentTimeMillis()));
            return commentRepository.save(comment);
        } catch (IllegalArgumentException e) {
            // Handle the exception or rethrow it if needed
            throw new RuntimeException("Invalid postId", e);
        }



    }

    @Override
    public Comment updateComment(CommentDTO request, String commentId, User user) {
        UUID id = UUID.fromString(commentId);
        Comment comment = commentRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy comment với :" + commentId));
        comment.setNoiDung(request.getNoiDung());
        comment.setCreateBy(user.getFirstName());
        comment.setModifiedBy(user.getFirstName());
        comment.setModifiedDate(new Date(System.currentTimeMillis()));
        comment.setCreateDate(new Date(System.currentTimeMillis()));
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(String id, User user) {
        Comment comment = commentRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy comment với :" + id));
        System.out.println("Delete success" + id);
        commentRepository.delete(comment);
    }
}
