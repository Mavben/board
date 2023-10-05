package com.example.boardar.service;

import com.example.boardar.dto.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    public int getTotalCount() {
        return 0;
    }

    public List<Board> getBoards(int page) {
        return null;
    }

    public Board getBoard(int boardId) {
        return null;
    }

    public void getBoard(Object userId, String title, String content) {
    }

    public void deleteBoard(int boardId) {
    }

    public Board getBoard(int boardId, boolean b) {
        return null;
    }

    public void updateBoard(int boardId, String title, String content) {
    }

    public void deleteBoard(Object userId, int boardId) {
    }
}
