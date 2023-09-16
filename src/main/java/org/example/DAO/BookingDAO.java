package org.example.DAO;

import java.io.Serializable;
import java.util.List;
import org.example.Database.Database;
import org.example.Entities.Booking;

public class BookingDAO implements Serializable {
    private Database db = Database.getInstance();
    public List<Booking> getAll(){return db.getBookings();}

    public boolean create(Booking booking){
        if(booking == null) return false;
        if(db.getBookings().contains(booking)) return false;
        db.getBookings().add(booking);
        return true;
    }

    public boolean delete(Booking booking){
        return db.getBookings().remove(booking);
    }
}
