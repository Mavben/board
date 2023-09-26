package com.example.boardar.controller;

// paging
/* 최신순, 좋아요, 조회수순 정렬
    1. PostController로 카테고리명, 정렬 기준 파라미터를 넘겨받고 PostService를 호출한다.
    2. PostService에서 정렬 기준 파라미터를 이용해 정렬한 Pageable 객체를 생성하고 PostRepository를 호출하여 카테고리명과 Pageable을 넘겨 PostDto 타입의 page 객체를 받아 반환한다.
    3. PostController에서 page 객체를 뷰로 반환한다.
*/

import com.example.boardar.service.PostService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
//
//    @GetMapping("/post")
//    public String

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

}
