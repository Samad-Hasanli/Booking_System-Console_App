package org.example.DAO;

import org.example.Database.Database;
import org.example.Entities.User;

import java.util.List;


public class UserDAO {
    private Database db = Database.getInstance();

    public List<User> getAll(){
        return db.getUsers();
    }

    public boolean create(User user){
        if(user == null) return false;
        if(db.getUsers().contains(user)) return false;
        db.getUsers().add(user);
        return true;
    }


}
