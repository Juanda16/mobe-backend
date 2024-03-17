package com.ssmu.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssmu.security.model.AppUser;
import com.ssmu.security.repositories.UserRepository;
import java.util.List;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public AppUser saveUser(AppUser user) {
        return userRepository.save(user);
    }

    public AppUser updateUser(AppUser user) {
        return userRepository.save(user);
    }

    public AppUser getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public AppUser getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public AppUser getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteUser(AppUser user) {
        userRepository.delete(user);
    }


}