package com.epam.jmp.tabayeu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.jmp.tabayeu.model.User;

@Service
public class CollectionBasedUserService implements UserService{

    private List<User> users = new ArrayList<>();

    private List<Byte[]> images = new ArrayList<>();

    @Override
    public void createUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    @Override
    public User readUser(long userId) {
        User result = null;
        for (User currentUser : users) {
            if (currentUser.getId() == userId) {
                result = currentUser;
            }
        }
        return result;
    }

    @Override
    public void updateUser(long userId, User user) {
        User result = readUser(userId);
        if (result != null) {
            deleteUser(userId);
        }
        createUser(user);
    }

    @Override
    public void deleteUser(long userId) {
        User result = null;
        for (User currentUser : users) {
            if (currentUser.getId() == userId) {
                result = currentUser;
            }
        }
        if (result != null) {
            users.remove(result);
        }
    }

    @Override
    public byte[] getPhoto(long userId) {
        User user = readUser(userId);
        if (user != null) {
            return user.getImage();
        } else {
            return null;
        }
    }

    @Override
    public void setPhoto(long userId, byte[] image) {
        User user = readUser(userId);
        if (user != null) {
            user.setImage(image);
        }
    }
}
