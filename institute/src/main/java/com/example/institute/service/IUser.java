package com.example.institute.service;

import com.example.institute.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUser {
    public UserEntity registerUser(UserEntity userEntity);
    public UserEntity saveUser(UserEntity user);
    public Optional<UserEntity> findByEmail(String email);
     public List<UserEntity> getUserDetailsFromDb();
     public void saveRegisterUser(UserEntity userEntity);

   public void saveLoginUser(UserEntity userEntity);

    public boolean validateUserCredentials(String email, String password);
}
