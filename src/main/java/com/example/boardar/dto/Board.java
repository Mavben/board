package com.example.boardar.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    public void setUserId(int userId) {
    }

    public boolean getUserId() {
        return false;
    }

    public void setTitle(String title) {
    }

    public void setContent(String content) {
    }

    public void setRegdate(LocalDateTime now) {
    }

    public void setBoardId(int boardId) {
    }
}
