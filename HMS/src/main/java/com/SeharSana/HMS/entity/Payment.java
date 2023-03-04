package com.SeharSana.HMS.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "invoice_no")
    private Long invoiceNo;
    @Column(name = "guest_id")
    private long guestId;
    @Column(name = "booking_id")
    private Long bookingId;
    @Column(name = "payment_date")
    private int paymentDate;

}
