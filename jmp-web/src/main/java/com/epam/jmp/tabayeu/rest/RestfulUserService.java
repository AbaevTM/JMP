package com.epam.jmp.tabayeu.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.epam.jmp.tabayeu.model.User;
import com.epam.jmp.tabayeu.service.UserService;


@Controller
@RequestMapping("service/v1")
public class RestfulUserService {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    void createUser(@RequestParam(value = "user", required = true) User user) {
        userService.createUser(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    User readUser(@PathVariable("id") long userId) {
        return userService.readUser(userId);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    void updateUser(@PathVariable("id") long userId, @RequestParam(value = "user", required = true) User user) {
        userService.updateUser(userId, user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable("id") long userId) {
        userService.deleteUser(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/users/{id}/photo", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getphoto(@PathVariable("id") long userId) {
        return userService.getPhoto(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/users/{id}/photo", method = RequestMethod.PUT, consumes = MediaType.IMAGE_JPEG_VALUE)
    public void setphoto(@PathVariable("id") long userId, @RequestParam(value = "photo") MultipartFile photo) throws IOException {
        userService.setPhoto(userId, photo.getBytes());
    }
}
