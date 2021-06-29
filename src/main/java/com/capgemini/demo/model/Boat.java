package com.capgemini.demo.model;

public class Boat {
// POJO a 'Plain Old Java Object'
    long id;
    String name;
    int seats;

    public Boat(long id, String name, int seats) {
        this.id = id;
        this.name = name;
        this.seats = seats;
    }

    // No arg constructor because we have a args constructor but Spring needs a no arg constructor when it creates json
    public Boat() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
