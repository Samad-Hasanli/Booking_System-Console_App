package org.example.Controllers;

import org.example.Entities.User;
import org.example.Services.UserService;

public class UserController {
    UserService userService = new UserService();

    public void saveRegister(User user){
        userService.saveRegister(user);
    }


}
