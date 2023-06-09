package com.practice.controller;

import com.practice.model.User;
import com.practice.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Post
    public HttpResponse<User> createUser(@Body @Valid User user){
        return HttpResponse.created(userService.createUser(user));
    }

    @Get
    public HttpResponse<List<User>> getAllUsers(){
        return HttpResponse.ok(userService.getUsers());
    }

    @Get("/{id}")
    public HttpResponse<User> getUserById(@PathVariable int id){
        return HttpResponse.ok(userService.getUser(id));
    }

    @Put("/{id}")
    public HttpResponse<User> updateUser(@PathVariable int id, @Body @Valid User user){
        return HttpResponse.ok(userService.updateUser(id,user));
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return HttpResponse.ok();
    }

}
