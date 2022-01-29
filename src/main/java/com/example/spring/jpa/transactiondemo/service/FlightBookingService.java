package com.example.spring.jpa.transactiondemo.service;


import com.example.spring.jpa.transactiondemo.dto.FlightBookingAcknowledgement;
import com.example.spring.jpa.transactiondemo.dto.FlightBookingRequest;
import com.example.spring.jpa.transactiondemo.entity.PassengerInfo;
import com.example.spring.jpa.transactiondemo.entity.PaymentInfo;
import com.example.spring.jpa.transactiondemo.repository.PassengerInfoRepository;
import com.example.spring.jpa.transactiondemo.repository.PaymentInfoRepository;
import com.example.spring.jpa.transactiondemo.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);

    }
}