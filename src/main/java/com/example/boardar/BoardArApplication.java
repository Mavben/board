/*

1. FrontEnd : 자유(jsp, 타임리프, 앵귤러.JS, VUE.JS, React)
2. BackEnd : Spring boot
             - RESTful API
			 - Login(jwt로 구현)
			 - Paging(더보기 안됨)
			 - N + 1 문제 해결
			 - Comment 기능
			 - Attach File

*/

package com.example.boardar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardArApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardArApplication.class, args);
    }

}
