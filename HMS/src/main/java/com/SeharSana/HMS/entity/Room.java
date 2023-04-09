package com.SeharSana.HMS.entity;

import com.SeharSana.HMS.Utility.EnRoomType;
import com.SeharSana.HMS.exception.RoomNotFoundException;
import com.SeharSana.HMS.model.RoomModel;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Table(name="room")
@Data
@Component
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "room_no", unique = true)
    private Long  roomNumber;
    @Column(name = "beds")
    private int beds;
    @Column(name="room_price")
    private long roomPrice;
    public boolean isReserved;
    @OneToOne(mappedBy = "room")
    private Reservation reservation;
    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private EnRoomType roomType;
    @Column(name ="en_room_type")
    private String enRoomType;

    public Room()
    {
    }

    public RoomModel orElseThrow(RoomNotFoundException roomNotFound)
    {
        return new RoomModel(reservation.getRoom( ));
    }
}
