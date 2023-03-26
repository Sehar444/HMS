package com.SeharSana.HMS.Repository;

import com.SeharSana.HMS.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {

    Guest findGuestById(Long guestId);
    Guest findGuestByCnic(Long guestCnic);

}
