package com.example.spring.jpa.transactiondemo.controller;

import com.example.spring.jpa.transactiondemo.dto.FlightBookingAcknowledgement;
import com.example.spring.jpa.transactiondemo.dto.FlightBookingRequest;
import com.example.spring.jpa.transactiondemo.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightBookingController {

    @Autowired
    FlightBookingService service;

    @PostMapping("/bookFlightTicket")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
        return service.bookFlightTicket(request);
    }

}
