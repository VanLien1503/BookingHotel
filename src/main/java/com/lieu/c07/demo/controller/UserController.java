package com.lieu.c07.demo.controller;

import com.lieu.c07.demo.model.User;
import com.lieu.c07.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/creat", method = RequestMethod.GET)
    public ModelAndView creatUserPage() {
        ModelAndView modelAndView = new ModelAndView("Form_SignUP/index");
        modelAndView.addObject("users", new User());
        return modelAndView;
    }
    @RequestMapping(value = "/creatNewUser",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User creatUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.save(user);
    }

//

    @RequestMapping(value = "", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<User> allUser(Pageable pageable){
        return userService.findAll(pageable);
    }
    @GetMapping("/viewUser")
    public ModelAndView allUserPageble(@PageableDefault(2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");

        modelAndView.addObject("allUser", allUser(pageable));
        return modelAndView;
    }
}
