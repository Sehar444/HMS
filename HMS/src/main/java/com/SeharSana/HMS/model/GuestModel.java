package com.SeharSana.HMS.model;
import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.entity.Room;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class GuestModel {
    private String guestName;
    private String guestCnic;
    private String phoneNo;
    private String address;
    private int noOfPersons;
    public Guest disassemble(){
        Guest guest=new Guest();
        guest.setGuestName(guestName);
        guest.setGuestCnic(guestCnic);
        guest.setPhoneNo(phoneNo);
        guest.setAddress(address);
        guest.setNoOfPersons(noOfPersons);
        return guest;
    }
    public GuestModel assemble(Guest guest){
        GuestModel guestModel=new GuestModel();
        guestModel.setGuestName(guest.getGuestName());
        guestModel.setGuestCnic(guest.getGuestCnic());
        guestModel.setPhoneNo(guest.getPhoneNo());
        guestModel.setAddress(guest.getAddress());
        guestModel.setNoOfPersons(guest.getNoOfPersons());
        return guestModel;
    }


}
