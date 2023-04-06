package com.SeharSana.HMS.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_no")
    private Long invoiceNo;
    @Column(name = "payment_date")
    private int paymentDate;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;


    public void setReservation(Reservation reservation) {
    }
}
