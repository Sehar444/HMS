package com.SeharSana.HMS.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="Payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_no")
    private Long invoiceNo;
    @Column(name = "payment_date")
    private Date paymentDate;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

}
