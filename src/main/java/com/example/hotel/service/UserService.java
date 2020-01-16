package com.example.hotel.service;

import com.example.hotel.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UserService{


    public List<User> list() {
        List<User> list = Arrays.asList();

        return  list;

    }


    public Page<User> findAll(Pageable pageable) {
        return null;
    }


    public <S extends User> S saveAndFlush(S entity) {
        return null;
    }
}
