package com.example.spring.jpa.transactiondemo;

import com.example.spring.jpa.transactiondemo.dto.FlightBookingRequest;
import com.example.spring.jpa.transactiondemo.entity.PassengerInfo;
import com.example.spring.jpa.transactiondemo.entity.PaymentInfo;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

@SpringBootApplication
@EnableTransactionManagement
public class TransactiondemoApplication implements CommandLineRunner{

	Gson gson= new Gson();

	public static void main(String[] args) {
		SpringApplication.run(TransactiondemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PassengerInfo passengerInfo= new PassengerInfo();
		passengerInfo.setDestination("Vizag");
		passengerInfo.setEmail("ravivarmachaluvadi@gmail.com");
		passengerInfo.setFare(1000);
		passengerInfo.setArrivalTime("6.0 PM");
		passengerInfo.setPickupTime("4.0 PM");
		passengerInfo.setTravelDate(new Date());
		passengerInfo.setSource("Bangalore");
		passengerInfo.setName("Ravi Varma");
		PaymentInfo paymentInfo= new PaymentInfo();
		paymentInfo.setAccountNo("acc1");
		paymentInfo.setCardType("DEBIT");
		FlightBookingRequest flightBookingRequest= new FlightBookingRequest();
		flightBookingRequest.setPassengerInfo(passengerInfo);
		flightBookingRequest.setPaymentInfo(paymentInfo);
		gson.toJson(flightBookingRequest);
	}
}
