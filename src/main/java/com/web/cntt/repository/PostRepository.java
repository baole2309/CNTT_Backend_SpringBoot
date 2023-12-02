package com.web.cntt.repository;

import com.web.cntt.model.Post;
import com.web.cntt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findPostsByUser(User user);
}
