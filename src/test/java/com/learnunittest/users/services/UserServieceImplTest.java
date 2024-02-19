package com.learnunittest.users.services;

import com.learnunittest.users.model.UserData;
import com.learnunittest.users.repo.UserDetailsRepo;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServieceImplTest {

    @InjectMocks
    private UserServieceImpl userServiece;

    @Mock
    private UserDetailsRepo userDetailsRepo;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllUsers() {

        List<UserData> userDataList = Arrays.asList(new UserData(1l,"Amol"));
        when(userDetailsRepo.findAll()).thenReturn(userDataList);
        assertEquals(1, userServiece.getAllUsers().size());
    }

    @Test
    void save() {
        UserData userData = new UserData(2l,"Renuka");
        when(userDetailsRepo.save(Mockito.any(UserData.class))).thenReturn(userData);

        assertEquals(2l,userServiece.save(new UserData(3l,"Renuka")).getUserId());
    }

    @Test
    void remove() {
        UserData userData = new UserData(2l,"Renuka");
        when(userDetailsRepo.findById(2l)).thenReturn(Optional.of(userData));

        assertAll(()->userServiece.remove(2l));
    }

//    @Test
//    public void saveThrowsException(){
//
//        when(userDetailsRepo.save(any())).thenThrow(new RuntimeException("no id found to remove"));
//        assertThrows(RuntimeException.class,()->userServiece.save(null));
//    }
}