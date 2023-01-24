package com.sinemturkcu.ticketapplication.Controllers;

import com.sinemturkcu.ticketapplication.Entities.User;
import com.sinemturkcu.ticketapplication.Services.UserService;
import com.sinemturkcu.ticketapplication.dto.UpdateUserDto;
import com.sinemturkcu.ticketapplication.dto.UserListDto;
import com.sinemturkcu.ticketapplication.responses.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public GenericResponse saveUser(@RequestBody User user){
        userService.saveUser(user);
        return new GenericResponse("User created successfully");
    }
    @DeleteMapping("/deleteUser")
    public GenericResponse delete(@RequestParam Long id){
        userService.deleteUser(id);
        return new GenericResponse("User deleted successfully");
    }

    @PutMapping("/updateuser")
    public GenericResponse updateUser(@RequestBody UpdateUserDto updateUserDto) {
        userService.updateUser(updateUserDto);
        return new GenericResponse("User updated successfully");
    }

    @GetMapping("/getAll")
    public List<UserListDto> getAll(){
       return userService.getAllUsers();
    }

}
