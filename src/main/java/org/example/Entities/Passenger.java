package org.example.Entities;

import java.io.Serializable;
import java.util.Objects;

public class Passenger implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int idCounter = 1;
    private int id;
    private String name;
    private String surname;


    public Passenger(String name, String surname) {
        this.id = idCounter++;
        this.name = name;
        this.surname = surname;
    }

    public Passenger(int id, String name, String surname) {
        idCounter = id;
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
    public Passenger(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return getId() == passenger.getId() && Objects.equals(getName(), passenger.getName()) && Objects.equals(getSurname(), passenger.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname());
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
