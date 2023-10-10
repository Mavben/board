package com.example.boardar.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data

    public class BoardDto {
        private int boardIdx;
        private String title;
        private String contents;
        private int hitCnt;
        private String creatorId;
        private LocalDateTime createdDatetime;
        private String updaterId;
        private LocalDateTime updatedDatetime;

    public void setBoardId(int boardId) {
    }
}