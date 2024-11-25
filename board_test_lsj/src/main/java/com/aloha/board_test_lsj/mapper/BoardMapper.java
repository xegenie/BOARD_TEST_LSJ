package com.aloha.board_test_lsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.board_test_lsj.dto.Board;
import com.aloha.board_test_lsj.dto.Page;

@Mapper
public interface BoardMapper {
    
    public int insert(Board board);

    // public List<Board> list();
    public List<Board> list(Page page);
    public int count();
    
    public Board select(String id);

    public int update(Board board);
    
    public int delete(String id);

}
