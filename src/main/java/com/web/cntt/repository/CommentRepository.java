package com.web.cntt.repository;

import com.web.cntt.model.Comment;
import com.web.cntt.model.Post;
import com.web.cntt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findCommentsByUser(User user);
    List<Comment> findCommentsByPost(Post post);
}
