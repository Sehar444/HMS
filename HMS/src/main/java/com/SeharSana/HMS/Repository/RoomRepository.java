package com.SeharSana.HMS.Repository;

import com.SeharSana.HMS.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findRoomByRoomNumber(Long roomNumber);
    Room findRoomByRoomPrice(Long roomPrice);
}
