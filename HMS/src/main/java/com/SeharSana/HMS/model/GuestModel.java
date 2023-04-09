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
    public Guest disassemble()
    {
        Guest npGuest = new Guest();
        npGuest.setId(this.getGuestId());
        npGuest.setName(this.getGuestName());
        npGuest.setEmail(this.getGuestEmail());
        npGuest.setNoOfPersons(this.getNoOfPersons());
        npGuest.setPhoneNumber(this.getGuestPhoneNumber());
        return npGuest;
    }

    public GuestModel assemble(Guest guest) {
        GuestModel guestModel = new GuestModel( );
        guestModel.setGuestId(guest.getId( ));
        guestModel.setGuestName(guest.getName( ));
        guestModel.setGuestEmail(guest.getEmail( ));
        guestModel.setNoOfPersons(guest.getNoOfPersons( ));
        guest.setPhoneNumber(guest.getPhoneNumber( ));
        return guestModel;
    }

    public GuestModel(Guest guest)
    {
        this.guestId=guest.getId();
        this.guestName=guest.getName();
        this.guestEmail=guest.getEmail();
        this.guestPhoneNumber=guest.getPhoneNumber();
        this.noOfPersons=guest.getNoOfPersons();
    }
    public  GuestModel(){

    }


}




