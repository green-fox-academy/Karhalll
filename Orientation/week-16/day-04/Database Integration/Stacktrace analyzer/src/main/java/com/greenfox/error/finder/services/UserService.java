package com.greenfox.error.finder.services;

import com.greenfox.error.finder.models.User;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public List<User> getAll() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }
}
