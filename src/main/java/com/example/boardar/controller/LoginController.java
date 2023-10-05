package com.example.boardar.controller;

import com.example.boardar.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class LoginController {
    @PostMapping(value = "/logout")
    //@ApiOperation(value="로그아웃")
    public ResponseEntity<Void> logout(HttpServletRequest servletRequest) {

        LoginService loginService = new LoginService();
        loginService.logout();
        return ResponseEntity.ok().build();
    }
}
