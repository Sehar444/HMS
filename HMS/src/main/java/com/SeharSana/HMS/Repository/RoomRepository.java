package com.SeharSana.HMS.Repository;

import com.SeharSana.HMS.Utility.EnRoomType;
import com.SeharSana.HMS.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findRoomByRoomNumber(Long roomNumber);
    Room findRoomByRoomPrice(Long roomPrice);
    Room findRoomByRoomType(String roomType);
    Optional<Room> findByRoomNumberAndReservationIsNull(Long roomNumber);
    List<Room> findByRoomTypeAndReservationIsNull(EnRoomType roomType);
}
