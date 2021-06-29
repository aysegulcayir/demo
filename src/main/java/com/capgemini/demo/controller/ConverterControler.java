package com.capgemini.demo.controller;

import com.capgemini.demo.model.Boat;
import com.capgemini.demo.model.Message;
import com.capgemini.demo.service.BoatService;
import com.capgemini.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConverterControler {

    @GetMapping(value= "/convert", produces= "application/json")
    public ResponseEntity<Message> toCelcius(@RequestParam( name="celcius", required =false )Double f,
                                            @RequestParam( name="fahrenheit", required =false )Double c){


        if (c==null ){
            Message message = new Message(" the coverted value is "+Util.toCelcius(f));
            return new ResponseEntity<>( message, HttpStatus.OK);

        }
        if(f==null){
            Message message = new Message(" the coverted value is "+Util.toCelcius(c));
            return new ResponseEntity<>( message, HttpStatus.OK);
        }

        if(c!=0&&f!=null) {
            Message message = new Message(" you must enter one value ");
            return new ResponseEntity<>( message, HttpStatus.OK);
        }

            Message message = new Message(" something wrong ");
            return new ResponseEntity<>( message, HttpStatus.OK);

}}
