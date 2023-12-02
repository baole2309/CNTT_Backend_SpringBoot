package com.web.cntt.service;

import com.web.cntt.dto.CommentDTO;
import com.web.cntt.dto.QuyCheDTO;
import com.web.cntt.model.Comment;
import com.web.cntt.model.User;

import java.net.UnknownServiceException;
import java.util.List;

public interface ICommentService {
    public List<Comment> getAllComment(User user);
    public Comment getCommentById(String id, User user);
    public List<Comment> getCommentByPost(String postId, User user);
    public List<Comment> getCommentByUser(User user);
    public Comment addComment(CommentDTO request, String postId, User user);
    public Comment updateComment(CommentDTO request, String commentId, User user);
    public void deleteComment(String id, User user);
}
