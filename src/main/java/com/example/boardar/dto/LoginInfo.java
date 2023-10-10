package com.example.boardar.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor

public class LoginInfo {

    public LoginInfo(Object userId, Object email, Object name) {
    }

    public Object getUserId() {
        return false;
    }

    public List<String> getRoles() {
        return null;
    }

    public void setRoles(List<String> roles) {
    }
}
