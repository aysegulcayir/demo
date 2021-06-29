package com.capgemini.demo.service;

import com.capgemini.demo.model.Boat;

import java.util.List;

public interface BoatService {

    public Boat getBoatById( long id);
    public List<Boat> getAllBoats();
    public Boat createBoat( Boat boat);
    void removeBoatById(long id);

}
