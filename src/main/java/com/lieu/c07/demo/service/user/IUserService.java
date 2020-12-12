package com.lieu.c07.demo.service.user;


import com.lieu.c07.demo.model.User;
import com.lieu.c07.demo.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;
 // extends UserDetailsService >>loadUserByUsername (String name) tra ve UserDetails
public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findByUsername(String username);
}
