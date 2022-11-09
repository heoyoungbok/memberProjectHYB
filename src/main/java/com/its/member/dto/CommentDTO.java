package com.its.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.security.Timestamp;

@Getter
@Setter
@ToString
public class CommentDTO {
    private Long commentId;
    private String commentWriter;
    private String commentContents;
    private Long boardId;
    private Timestamp commentCreatedDate;
}
