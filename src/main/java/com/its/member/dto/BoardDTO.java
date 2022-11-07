package com.its.member.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.security.Timestamp;
@Getter
@Setter
@ToString
public class BoardDTO {
    private Long boardId;
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private int boardHits;
    private Timestamp boardCreatedDate;
    private MultipartFile boardFile;
    private String originalFileName;
    private String storedFileName;
    private int fileAttached;
}
