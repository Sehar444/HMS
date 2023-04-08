package com.SeharSana.HMS.model;
import com.SeharSana.HMS.entity.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class GuestModel {
    private Long guestId;
    private String guestName;
    private String guestEmail;
    private Long guestPhoneNumber;
    private String guestAddress;
    private Long noOfPersons;
    private List<Reservation> reservation;
    private List<SpecialRequirements> specialRequirements;
    private List<Payment> payment;
    public Guest disassemble()
    {
        Guest npGuest = new Guest();
        npGuest.setId(this.getGuestId());
        npGuest.setName(this.getGuestName());
        npGuest.setEmail(this.getGuestEmail());
        npGuest.setNoOfPersons(this.getNoOfPersons());
        npGuest.setPhoneNumber(this.getGuestPhoneNumber());
        npGuest.setReservation(this.getReservation());
        npGuest.setSpecialRequirements(this.getSpecialRequirements());
        npGuest.setPayment(this.getPayment());
        return npGuest;
    }

    public GuestModel(Guest guest)
    {
        this.guestId=guest.getId();
        this.guestName=guest.getName();
        this.guestEmail=guest.getEmail();
        this.guestPhoneNumber=guest.getPhoneNumber();
        this.noOfPersons=guest.getNoOfPersons();
        this.reservation=guest.getReservation();
        this.specialRequirements=guest.getSpecialRequirements();
        this.payment=guest.getPayment();
    }
    public  GuestModel(){

    }


}




