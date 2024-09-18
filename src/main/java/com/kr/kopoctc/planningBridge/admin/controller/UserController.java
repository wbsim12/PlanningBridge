package com.kr.kopoctc.planningBridge.admin.controller;

import com.kr.kopoctc.planningBridge.admin.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.kr.kopoctc.planningBridge.admin.dto.UserDTO;

@Controller
@Slf4j
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/registerUser")
    public String inputData(Model model) {

        UserDTO userDTO = new UserDTO();

        userDTO.setAccount("");
        userDTO.setPassword("");
        userDTO.setEmail("");
        userDTO.setName("");
        userDTO.setPhoneNumber("");

        model.addAttribute("userDTO", userDTO);

        return "admin/registerUser";
    }

    @PostMapping("/registerUser")
    public String registerUser(@Valid @ModelAttribute("userDTO")UserDTO userDTO,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // 에러 정보를 모델에 추가
            log.info("여기를 들어와?");
            System.out.println("Errors: " + bindingResult.getAllErrors());
            model.addAttribute("errors", bindingResult.getAllErrors());

            return "admin/registerUser";
        }

        if (userServiceImpl.getUserByAccount(userDTO.getAccount()) == null) {
            userServiceImpl.createUser(userDTO);
            return "admin/registerSuccess";
        } else {
            model.addAttribute("errorMessage", "중복되는 아이디 입니다");
            return "admin/registerUser";
        }

    }
}
