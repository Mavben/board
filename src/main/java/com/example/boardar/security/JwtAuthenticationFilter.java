package com.example.boardar.security;


/*
    < logout >

     jwt는 쿠키나 세션과 달리 강제로 만료시킬 수 없다. 따라서 로그아웃을 위해 다른 방법을 사용해야한다.
    로그인 시 Redis 같은 인메모리DB에 token 정보를 저장하고, 로그아웃 시 Redis에서 token 정보를 지움으로써 로그아웃 여부를 확인할 수 있다.
    (로그아웃 여부만 구분하면 되므로 로그아웃시 Redis에 token 정보를 저장하는 방식을 사용해도 된다.)

    기존 토큰 인증 방식 = 토큰이 만료될 때마다 리프레쉬 토큰의 정보를 가지고 액세스 토큰을 재발급할 수 있다.


 */

public class JwtAuthenticationFilter {
}
