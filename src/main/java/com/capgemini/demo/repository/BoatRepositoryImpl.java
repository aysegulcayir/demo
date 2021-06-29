package com.capgemini.demo.repository;

import com.capgemini.demo.model.Boat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoatRepositoryImpl implements BoatRepository{

    List<Boat> boats = new ArrayList<>();

    public BoatRepositoryImpl(){

        Boat boat = new Boat();
        boat.setId(0);
        boat.setName("Kayak");
        boat.setSeats(3);
        boats.add(boat);

        boats.add( new Boat( 0, "Kayak", 2));
        boats.add( new Boat( 1, "Roeiboot", 5));
        boats.add( new Boat( 2, "Zeilboot", 25));
        boats.add( new Boat( 3, "Skutsje", 45));
    }

    @Override
    public Boat getBoatById(long id) {

        for(Boat boat: boats){
            if(id == boat.getId()){
                return boat;
            }

        }

        return null;
    }

    @Override
    public List<Boat> getAllBoats() {

        return boats;

    }

    @Override
    public Boat createBoat(Boat boat) {

        boat.setId( boats.size());
        boats.add(boat);

        return boat;

    }

    @Override
    public void removeBoatById( long id) {

        for(Boat boat: boats){
            if(id == boat.getId()){
                boats.remove(boat);
                break;
            }

        }

    }


}
