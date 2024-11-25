package com.aloha.board_test_lsj.dto;

import java.util.Date;
import java.util.UUID;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Board")
public class Board {
    private Long no;
    private String id;
    private String title;
    private String writer;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    public Board() {
        this.id = UUID.randomUUID().toString();
    }

}
