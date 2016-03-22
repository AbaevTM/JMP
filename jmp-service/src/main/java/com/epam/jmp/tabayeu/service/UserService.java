package com.epam.jmp.tabayeu.service;

import com.epam.jmp.tabayeu.model.User;

public interface UserService {

    void createUser(User user);

    User readUser(long userId);

    void updateUser(long userId, User user);

    void deleteUser(long userId);

    byte[] getPhoto(long userId);

    void setPhoto(long userId, byte[] image);
}
