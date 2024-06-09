package com.ecommerce.ecom.service;

import com.ecommerce.ecom.model.User;
import com.ecommerce.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(User user) throws Exception{
            User isExist = userRepository.findOneByEmail(user.getEmail());
            if (isExist != null) {
                throw new Exception("Email already exists");
            }
            User u = userRepository.save(user);
            return  u;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
