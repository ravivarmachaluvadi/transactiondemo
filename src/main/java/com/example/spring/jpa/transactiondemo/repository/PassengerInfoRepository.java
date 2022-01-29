package com.example.spring.jpa.transactiondemo.repository;

import com.example.spring.jpa.transactiondemo.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, UUID> {
}
