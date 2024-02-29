package com.sample.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.model.User;
import com.sample.demo.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    //Create
    public User createUser(User user)
    {
        return userRepo.save(user);
    }
    //Read
    public List<User> getUsers()
    {
        return userRepo.findAll();
    }
    //Update
    public boolean updateUsers(int id,User u)
    {
        User toBeUpdated = userRepo.findById(id).orElse(null);
        if(toBeUpdated == null)
        {
            return false;
        }else{
            toBeUpdated.setUserName(u.getUserName());
            toBeUpdated.setEmailId(u.getEmailId());
            userRepo.save(toBeUpdated);
            return true;
        }
    }
    //Delete
    public boolean deleteUser(int id)
    {
        User toBeDeleted = userRepo.findById(id).orElse(null);
        if(toBeDeleted == null)
        {
            return false;
        }else{
            userRepo.delete(toBeDeleted);
            return true;
        }
    }
    //GetUserById
    public User getById(int id)
    {
        return userRepo.findById(id).orElse(null);
    }
}
