package com.capgemini.demo.controller;

import com.capgemini.demo.model.Boat;
import com.capgemini.demo.model.Message;
import com.capgemini.demo.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")       // Not mandatory
public class BoatController {

    BoatService boatService;

    public BoatController(){}

    @Autowired
    public BoatController(BoatService boatService){
        this.boatService = boatService;
    }

    // http://localhost:8080/api/boat/3/2/4
    // http://localhost:8080/api/boat/3
    @GetMapping(value= "/boat/{id1}/{id2}/{id3}", produces= "application/json")
    public ResponseEntity<Boat> getBoatById( @PathVariable(name="id1", required = true) long id){

//        Boat boat = boatService.getBoatById( id);
        Boat boat = new Boat(id, "Kayak", 4);

        return new ResponseEntity<>( boat, HttpStatus.OK);

    }

    // http://localhost:8080/api/boat/?id=2&id2=3&id3=12....
    // This is an http request of type GET
    @GetMapping(value= "/boatbyid", produces= "text/html")
    public String getBoatById2( @RequestParam( name="id", required =true ) long id){

//        Boat boat = boatService.getBoatById( id);
        Boat boat = new Boat(id, "Kayak", 4);

        String html = "<html><body><h2></h2>" +
                "<p>Id: " + boat.getId() + "</p>" +
                "<p>Name: " + boat.getName() + "</p>" +
                "<p>Seats: " + boat.getSeats() + "</p>" +
                "</h2></body></html>";

        return html;

    }


    // http://localhost:8080/api/boats
    // This is an http request of type GET
    @GetMapping(value= "/boats", produces= "application/json")
    public ResponseEntity<List<Boat>> getBoats(){

//        List<Boat> boats = boatService.getAllBoats();
        List<Boat> boats = new ArrayList<>();
        boats.add( new Boat(4, "Zeilboot", 40));

        return new ResponseEntity<>( boats, HttpStatus.OK);

    }

    // http://localhost:8080/api/boat
    // This is an http request of type POST, the json that represents the boat is in the body of the request
    @PostMapping(value= "/boat", produces= "application/json", consumes= "application/json")
    public ResponseEntity<Boat> createBoat( @RequestBody Boat boat){

        boat = boatService.createBoat( boat);

        return new ResponseEntity<>( boat, HttpStatus.OK);

    }

    // http://localhost:8080/api/boat/3
    // This is an http request of type DELETE
    // The url is the same as for the GET request. Spring boot maps the url with the type to a method
    @DeleteMapping(value= "/boat/{id}", produces= "application/json")
    public ResponseEntity<Message> removeBoatById( @PathVariable(name="id", required = true) long id){

        boatService.removeBoatById( id);

        return new ResponseEntity<>( new Message("Boat is deleted"), HttpStatus.OK);

    }

}
