package com.ssmu.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssmu.security.model.AppUser;
import com.ssmu.security.repositories.UserRepository;

@Service
public class GetAllUsers implements BaseUseCase<Void, List<AppUser>> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AppUser> call(Void data) {
        return userRepository.findAll();
    }

}
