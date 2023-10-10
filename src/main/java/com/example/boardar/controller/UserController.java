package com.example.boardar.controller;

//import com.example.boardar.dto.LoginInfo;
//import com.example.boardar.dto.UserDto;

import com.example.boardar.dto.LoginInfo;
import com.example.boardar.dto.UserDto;
import com.example.boardar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {
    private final UserService userService;

    @GetMapping("/userRegForm")
    public String userRegForm(){
        return "userRegForm";
    }

    @PostMapping("/userReg")
    public String userReg(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        System.out.println("name : " + name);
        System.out.println("email : " + email);
        System.out.println("password : " + password);

//        userService.addUser(name, email, password);

        return "redirect:/welcome"; //  브라우저에게 자동으로 http://localhost:8080/welcome 으로 이동
    }

    // http://localhost:8080/welcome
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/loginform")
    public String loginform(){
        return "loginform";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession httpSession // spring이 자동으로 session을 처리하는 HttpSession객체를 넣어준다.
    ){

        System.out.println("email : " + email);
        System.out.println("password : " + password);

        try{
            UserDto user = userService.getUser(email);
            if(user.getPassword().equals(password)){
                System.out.println("암호가 같습니다.");
                LoginInfo loginInfo = new LoginInfo(user.getUserId(), user.getEmail(), user.getName());

                List<String> roles = userService.getRoles(user.getUserId());
                loginInfo.setRoles(roles);

                httpSession.setAttribute("loginInfo", loginInfo); // 첫번째 파라미터가 key, 두번째 파라미터가 값.
                System.out.println("세션에 로그인 정보가 저장된다.");
            }else{
                throw new RuntimeException("암호가 일치하지 않음.");
            }
        }catch(Exception ex){
            return "redirect:/loginform?error=true";
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("loginInfo");
        return "redirect:/";
    }
}