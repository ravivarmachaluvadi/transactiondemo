package com.example.spring.jpa.transactiondemo.repository;

import com.example.spring.jpa.transactiondemo.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, UUID> {
}
