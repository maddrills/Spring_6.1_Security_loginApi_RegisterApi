package com.tryOne.AuthonBack.Services.Security;


import com.tryOne.AuthonBack.DAO.security.RoleDao;
import com.tryOne.AuthonBack.DAO.security.UserDao;
import com.tryOne.AuthonBack.entity.security.Role;
import com.tryOne.AuthonBack.entity.security.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
//actual be calling the db layer thats why
@Transactional
public class AuthenticationServiceSignUp {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //create a user dto then pass that info to the db
    public User registerUser(String userName, String password, String firstName, String lastName, String email){

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleDao.findRoleByName("ROLE_USER");

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        if(firstName == null || lastName == null || email == null){
            firstName = "--";
            lastName = "--";
            email = "--";
        }

        User user = new User(0, userName,encodedPassword,1,firstName,lastName,email,authorities);

        //set for login fields
        try {
            userDao.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return  user;
    }

}
