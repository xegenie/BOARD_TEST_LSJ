package com.aloha.board_test_lsj.service;

import java.util.List;

import com.aloha.board_test_lsj.dto.Board;
import com.aloha.board_test_lsj.dto.Page;

public interface BoardService {
    public int insert(Board board);

    public List<Board> list();
    public List<Board> list(Page page);
    
    public Board select(String id);

    public int update(Board board);
    
    public int delete(String id);    
}
