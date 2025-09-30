package com.example.api;

import com.example.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakeApiUserClient {
    // Представим что это настоящий API клиент, с помощью которого мы создаем пользователя в системе

    private final List<User> users = new ArrayList<>();

    public User createUser(String username, String password) {
        User user = new User(UUID.randomUUID(), username, password);
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }
}