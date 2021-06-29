package com.capgemini.demo.repository;

import com.capgemini.demo.model.Boat;

import java.util.List;

public interface BoatRepository {

    public Boat getBoatById( long id);
    public List<Boat> getAllBoats();
    public Boat createBoat( Boat boat);
    void removeBoatById(long id);
}
