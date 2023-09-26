package com.example.boardar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

public class LoginController {
    @PostMapping(value = "/logout")
    @ApiOperation(value="로그아웃")
    public ResponseEntity<Void> logout(HttpServletRequest servletRequest) {

        loginService.logout();
        return ResponseEntity.ok().build();
    }
}
