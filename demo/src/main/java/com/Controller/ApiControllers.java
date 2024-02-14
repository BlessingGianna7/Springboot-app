package com.Controller;

import com.Repo.UserRepo;
import com.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    private final UserRepo userRepo;

    @Autowired
    public ApiControllers(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping(value = "/")
    public String getPage() {
        return "welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(User user) {
        userRepo.save(user);
        return "Saved...";
    }

    @PutMapping(value = "update/{id")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        userRepo.save(updatedUser);
        return "Updated...";
    }


    @DeleteMapping(value = "/delete/{id")
    public  String deleteUser(@PathVariable long id){
        User deleteUser= userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return  "User has been deleted";
    }
}
