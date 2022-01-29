package com.example.spring.jpa.transactiondemo.dto;

import com.example.spring.jpa.transactiondemo.entity.PassengerInfo;
import com.example.spring.jpa.transactiondemo.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

    private PassengerInfo passengerInfo;

    private PaymentInfo paymentInfo;
}