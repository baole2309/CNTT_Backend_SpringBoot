package com.web.cntt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


import lombok.*;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CommentDTO extends AbstractDTO<CommentDTO>{
    private String maPost;
    private String noiDung;
    private String userId;
    private Date ngayBinhLuan;
}


