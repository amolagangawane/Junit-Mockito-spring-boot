package com.learnunittest.users.repo;


import com.learnunittest.users.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserData,Long> {
}
