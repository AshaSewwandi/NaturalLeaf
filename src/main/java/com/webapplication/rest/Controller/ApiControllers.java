package com.webapplication.rest.Controller;

import com.webapplication.rest.Model.Users;
import com.webapplication.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value= "/Welcome")
    public String getPage(){
        return "Welcome";
    }
    @GetMapping(value="/users")
    public List<Users> getUsers(){
        return userRepo.findAll();
    }
    @PostMapping(value="/save")
    public String saveUser(@RequestBody Users User){
        userRepo.save(User);
        return "saved...";
    }
    @PutMapping(value="/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody Users User){
        Users updateUser = userRepo.findById(id).get();
        updateUser.setFirstName(User.getFirstName());
        updateUser.setLastName(User.getLastName());
        updateUser.setAge(User.getAge());
        updateUser.setOccupation(User.getOccupation());
        userRepo.save(updateUser);
        return "Updated....";
    }
    @DeleteMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable long id){
        Users deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Delete user with the Id: "+id;
    }
}
