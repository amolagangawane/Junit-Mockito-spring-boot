package com.learnunittest.users;


import com.learnunittest.users.model.UserData;
import com.learnunittest.users.services.UserServieceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServieceImpl userServiece;


    @GetMapping("/")
    public ResponseEntity<List<UserData>> getAllUsers(){

        return ResponseEntity.ok(userServiece.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity<UserData> addUser(HttpServletRequest request, @NonNull @RequestBody UserData userData) {

        return ResponseEntity.ok(userServiece.save(userData));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> removeUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userServiece.remove(userId));
    }

    @PutMapping("/update")
    public ResponseEntity<UserData> updateUser( @RequestBody UserData userData) {
        return ResponseEntity.ok(userServiece.updateUser(userData));
    }
}
