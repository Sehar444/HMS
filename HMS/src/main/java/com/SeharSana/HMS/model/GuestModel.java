package com.SeharSana.HMS.model;
import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.entity.Room;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class GuestModel {
    private Long guestId;
    private String guestName;
    private Long guestCnic;
    private Long phoneNo;
    private String address;
    private int noOfPersons;
    private Room.RoomType roomType;

    public Guest disassemble() {
        Guest guestnp = new Guest();
        guestnp.setId(this.getGuestId());
        guestnp.setGuestName(this.getGuestName());
        guestnp.setGuestCnic(this.getGuestCnic());
        guestnp.setAddress(this.getAddress());
        guestnp.setNoOfPersons(this.getNoOfPersons());
        return guestnp;
    }

//    public GuestModel assemble(Guest guest) {
//        GuestModel guestModel = new GuestModel();
//        guestModel.setGuestId(guest.getGuestId());
//        guestModel.setGuestName(guest.getGuestName());
//        guestModel.setGuestCnic(guest.getGuestCnic());
//        guestModel.setPhoneNo(guest.getPhoneNo());
//        guestModel.setAddress(guest.getAddress());
//        guestModel.setNoOfPersons(guest.getNoOfPersons());
//        return guestModel;
//    }
    public GuestModel(Guest guest){
        this.guestId=guest.getId();
        this.guestCnic=guest.getGuestCnic();
    }
}




