package org.example.Menu;

import org.example.Controllers.UserController;
import org.example.Entities.User;
import org.example.Services.UserService;
import java.util.Scanner;

public class Register {
    UserController userController = new UserController();

    public void register(){
        User register = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Enter Name: ");
        String name = scanner.next();
        register.setName(name);

        System.out.print(" Enter Surname: ");
        String surname = scanner.next();
        register.setSurname(surname);

        System.out.print(" Enter Username: ");
        String username = scanner.next();
        register.setUsername(username);

        System.out.print(" Enter Password: ");
        String password = scanner.next();
        register.setPassword(password);

        userController.saveRegister(register);
        System.out.println("Register is successful!");

    }
}
