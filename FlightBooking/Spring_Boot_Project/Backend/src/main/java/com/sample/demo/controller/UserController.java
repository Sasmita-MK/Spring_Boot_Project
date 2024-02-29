package com.sample.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.model.User;
import com.sample.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    //Create
    @PostMapping("/insert")
    public User insertNewData(@RequestBody User InsertThis)
    {
        return userService.createUser(InsertThis);
    }
    //read
    @GetMapping("/getAll")
    public List<User> getAllUserData()
    {
        return userService.getUsers();
    }
    //Update
    @PutMapping("/update/{id}")
    public String UpdateTheUser(@PathVariable int id,@RequestBody User u)
    {
        boolean done = userService.updateUsers(id, u);
        if(done)
        {
            return "Updated";
        }
        else
        {
            return "ID Not found Enter the correct ID to be updated";
        }
    }
    //Delete
    @DeleteMapping("/delete/{id}")
    public String DeleteThisUser(@PathVariable int id)
    {
        boolean done = userService.deleteUser(id);
        if(done)
        {
            return "Successfully deleted";
        }else{
            return "ID Not found Enter the correct ID to be deleted";
        }
    }
}
