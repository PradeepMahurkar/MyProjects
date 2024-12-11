package com.example.institute.service.impl;

import com.example.institute.model.UserEntity;
import com.example.institute.repo.UserRepo;
import com.example.institute.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUser {
    @Autowired
    private UserRepo userRepository;

    @Override
    public UserEntity registerUser(UserEntity userEntity) {
        UserEntity userEntity1 = userRepository.save(userEntity);
//        System.out.println("Date of Birth: " + userEntity.getDateOfBirth());
        return userEntity1;
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        userRepository.save(user);

        return user;
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserEntity> getUserDetailsFromDb() {
        return userRepository.findAll();
    }

    @Override
    public void saveRegisterUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void saveLoginUser(UserEntity userEntity) {

    }

    @Override
    public boolean validateUserCredentials(String email, String password) {
        // Find user by username
        Optional<UserEntity> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            UserEntity user = userOpt.get();
            // Check if the password matches
            return user.getPassword().equals(password);
        }

        return false;
    }
}
