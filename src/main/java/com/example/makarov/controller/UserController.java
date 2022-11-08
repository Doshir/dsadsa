package com.example.makarov.controller;

import com.example.makarov.dto.UserDto;
import com.example.makarov.entity.User;
import com.example.makarov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping
    public UserDto finById(@RequestParam Long id ){
        User user = userRepository.findById(id).orElseThrow(()->new IllegalStateException("not find User"));
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    @PostMapping
    public String registration(@RequestBody User user){
        if(user!=null) {
            User user1 = new User();
            user1.setId(user.getId());
            user1.setUsername(user.getUsername());
            user1.setPassword(user.getPassword());
            userRepository.save(user1);
            return "User saved";
        }

        return "Mistake";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable Long id ){
        User user = userRepository.findById(id).orElseThrow(()->new IllegalStateException("not find User"));
        userRepository.delete(user);
        return "User succefull delete";
    }

    @PutMapping()
    public User update(@RequestBody User user){
        User userFromDataBase = userRepository.findById(user.getId()).orElseThrow(()->new IllegalStateException("not find User"));
        userFromDataBase.setPassword(user.getPassword());
        userFromDataBase.setId(user.getId());
        userFromDataBase.setUsername(user.getUsername());

        return userFromDataBase;
    }



}
