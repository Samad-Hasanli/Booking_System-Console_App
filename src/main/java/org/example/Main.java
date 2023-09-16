package org.example;

import org.example.Database.Database;
import org.example.Menu.Menu;

public class Main {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        db.initDatabase();
        Menu menu = new Menu();
        menu.mainmenu();
        db.closeDatabase();
    }
}