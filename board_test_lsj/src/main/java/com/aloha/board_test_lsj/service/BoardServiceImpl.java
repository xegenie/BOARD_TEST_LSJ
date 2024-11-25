package com.aloha.board_test_lsj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.board_test_lsj.dto.Board;
import com.aloha.board_test_lsj.dto.Page;
import com.aloha.board_test_lsj.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public int insert(Board board) {
        return boardMapper.insert(board);
    }

    @Override
    public List<Board> list() {
        return boardMapper.list(new Page());
    }

    @Override
    public Board select(String id) {
        return boardMapper.select(id);
    }

    @Override
    public int update(Board board) {
        return boardMapper.update(board);
    }

    @Override
    public int delete(String id) {
        return boardMapper.delete(id);
    }

    @Override
    public List<Board> list(Page page) {
        // 데이터 개수
        int total = boardMapper.count();
        page.setTotal(total);

        List<Board> boardList = boardMapper.list(page);

        return boardList;
    }
}