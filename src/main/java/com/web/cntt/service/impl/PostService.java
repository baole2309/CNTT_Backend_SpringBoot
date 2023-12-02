package com.web.cntt.service.impl;

import com.web.cntt.dto.PostDTO;
import com.web.cntt.model.Post;
import com.web.cntt.model.User;
import com.web.cntt.repository.PostRepository;
import com.web.cntt.service.IPostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final PostRepository postRepository;


    @Override
    public List<Post> getAllPost(User user) {
        try {
            return postRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải list lớp");
        }
    }

    @Override
    public List<Post> getPostByUser(User user) {
        try {
            return postRepository.findPostsByUser(user);
        } catch (Exception e) {
            throw new RuntimeException("Không thể tải list lớp");
        }
    }

    @Override
    public Post getPostById(String id, User user) {
        return postRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy post với :" + id));
    }

    @Override
    public Post addPost(PostDTO request, User user) {
        Post post = new Post();
        post.setId(UUID.randomUUID());
        post.setChuDe(request.getChuDe());
        post.setNoiDung(request.getNoiDung());
        post.setNgayDangBai(new Date(System.currentTimeMillis()));
        post.setUser(user);
        post.setCreateBy(user.getFirstName());
        post.setCreateDate(new Date(System.currentTimeMillis()));
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(PostDTO request, String id, User user) {
        Post post = postRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy post với :" + id));
        post.setChuDe(request.getChuDe());
        post.setNoiDung(request.getNoiDung());
        post.setNgayDangBai(new Date(System.currentTimeMillis()));
        post.setUser(user);
        post.setCreateBy(user.getFirstName());
        post.setCreateDate(new Date(System.currentTimeMillis()));
        return postRepository.save(post);
    }

    @Override
    public void deletePost(String id, User user) {
        Post post = postRepository.findById(UUID.fromString(id)).orElseThrow(()
                -> new IllegalArgumentException("không thể tìm thấy post với :" + id));
        System.out.println("Delete success" + id);
        postRepository.delete(post);
    }
}
