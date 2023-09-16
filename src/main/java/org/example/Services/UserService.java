package org.example.Services;

import org.example.DAO.UserDAO;
import org.example.Entities.User;

public class UserService {
    private UserDAO userDao = new UserDAO();

    public void saveRegister(User user){
        userDao.create(user);
    }

}
