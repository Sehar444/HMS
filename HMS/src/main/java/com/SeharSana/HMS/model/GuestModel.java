package com.SeharSana.HMS.model;
import com.SeharSana.HMS.entity.*;
import lombok.Data;
import java.util.List;


@Data
public class GuestModel {
    private Long guestId;
    private String guestName;
    private Long guestCnic;
    private Long guestPhoneNo;
    private String guestAddress;
    private Long noOfPersons;
    private List<Room> room;
    private List<Reservation> reservation;
    private List<SpecialRequirements> specialRequirements;
    private List<Payment> payment;
    public Guest disassemble() {
        Guest npGuest = new Guest();
        npGuest.setId(this.getGuestId());
        npGuest.setName(this.getGuestName());
        npGuest.setCnic(this.getGuestCnic());
        npGuest.setAddress(this.getGuestAddress());
        npGuest.setNoOfPersons(this.getNoOfPersons());
        npGuest.setPhoneNo(this.getGuestPhoneNo());
        npGuest.setRoom(this.getRoom());
        npGuest.setReservation(this.getReservation());
        npGuest.setSpecialRequirement(this.getSpecialRequirements());
        npGuest.setPayment(this.getPayment());
        return npGuest;
    }

    public GuestModel(Guest guest){
        this.guestId=guest.getId();
        this.guestName=guest.getName();
        this.guestCnic=guest.getCnic();
        this.guestAddress=guest.getAddress();
        this.guestPhoneNo=guest.getPhoneNo();
        this.noOfPersons=guest.getNoOfPersons();
        this.room=guest.getRoom();
        this.reservation=guest.getReservation();
        this.specialRequirements=guest.getSpecialRequirements();
        this.payment=guest.getPayment();
    }
    public  GuestModel(){

    }


}




