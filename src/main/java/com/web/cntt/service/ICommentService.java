package com.web.cntt.service;

import com.web.cntt.dto.QuyCheDTO;
import com.web.cntt.model.Comment;

import java.util.List;

public interface ICommentService {
    public List<Comment> getAllComment();
    public Comment getSCommentById(String id);
    public Comment addComment(QuyCheDTO request);
    public Comment updateComment(QuyCheDTO request, String id);
    public void deleteComment(String id);
}
