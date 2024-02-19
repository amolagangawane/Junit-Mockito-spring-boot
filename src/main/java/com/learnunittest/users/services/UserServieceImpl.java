package com.learnunittest.users.services;

import com.learnunittest.users.model.UserData;
import com.learnunittest.users.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServieceImpl {

    @Autowired
    UserDetailsRepo userDetailsRepo;

    public List<UserData> getAllUsers(){
        return userDetailsRepo.findAll();
    }

    public UserData save(UserData data){
        return userDetailsRepo.save(data);
    }

    public String remove(Long userId){
        userDetailsRepo.deleteById(userId);
        return "user with : "+ userId +"removed successfully";
    }

    public UserData updateUser(UserData userData) {
        Optional<UserData> toBeModify = userDetailsRepo.findById(userData.getUserId());

        UserData updatedUser = toBeModify.get();
        updatedUser.setName(userData.getName());
        return userDetailsRepo.save(updatedUser);
    }
}
