package org.example.Menu;

import org.example.DAO.UserDAO;
import org.example.Entities.User;

import java.util.Scanner;

public class Login{
    private int abc;

    public int getAbc() {
        return abc;
    }

    public void login() {
        User login = new User();
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.print(" Enter Username: ");
        String username = scanner.next();
        login.setUsername(username);

        System.out.print(" Enter Password: ");
        String password = scanner.next();
        login.setPassword(password);


        boolean isEqual = false;
        for (User user : userDAO.getAll()) {
            if (login.isEqualTo(user)) {
                isEqual = true;
                break;
            }
        }
        if (isEqual) {
            System.out.println("Login is successful!");
            abc = 1;
        }
        else {
            System.out.println("Login is not successful!");
            abc = 0;
        }

    }
}
