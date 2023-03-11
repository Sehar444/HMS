package com.SeharSana.HMS.Repository;

import com.SeharSana.HMS.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
