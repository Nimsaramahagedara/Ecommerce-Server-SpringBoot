package com.ecommerce.ecom.controller;

import com.ecommerce.ecom.dto.ErrorResponse;
import com.ecommerce.ecom.model.User;
import com.ecommerce.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody User user){
        try {
           User createdUser = userService.createUser(user);
           return new ResponseEntity<>(createdUser,HttpStatus.OK);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(),"");
            return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
