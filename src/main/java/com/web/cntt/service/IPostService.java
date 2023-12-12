package com.web.cntt.service;

import com.web.cntt.dto.PostDTO;
import com.web.cntt.dto.QuyCheDTO;
import com.web.cntt.model.Comment;
import com.web.cntt.model.Post;
import com.web.cntt.model.QuyChe;
import com.web.cntt.model.User;

import java.util.List;

public interface IPostService {
    public List<Post> getAllPost(User user);
    public List<Post> getTopPost(User user);
    public List<Post> getPostByUser(User user);
    public Post getPostById(String id, User user);
    public Post addPost(PostDTO request, User user);
    public Post updatePost(PostDTO request, String id, User user);
    public void deletePost(String id, User user);
}
