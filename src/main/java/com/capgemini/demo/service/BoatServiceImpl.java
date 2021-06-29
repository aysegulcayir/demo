package com.capgemini.demo.service;

import com.capgemini.demo.model.Boat;
import com.capgemini.demo.repository.BoatRepository;
import com.capgemini.demo.repository.BoatRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatServiceImpl implements BoatService{

    BoatRepository boatRepository;

    public BoatServiceImpl(){}

    @Autowired
    public BoatServiceImpl( BoatRepository boatRepository){
        this.boatRepository = boatRepository;
    }

    @Override
    public Boat getBoatById(long id) {

        Boat boat = boatRepository.getBoatById( id);
        return boat;
    }

    @Override
    public List<Boat> getAllBoats() {

        List<Boat> boats = boatRepository.getAllBoats();

        // return boats with seats > 25
        // Loop through te list and extact Boats > 25
        // Business logic

        // Check if boats are available
        // Check with other service to get Reservations

        return boats;

    }

    @Override
    public Boat createBoat(Boat boat) {
        boat = boatRepository.createBoat( boat);
        return boat;
    }

    @Override
    public void removeBoatById(long id) {
        boatRepository.removeBoatById(id);
    }

}
