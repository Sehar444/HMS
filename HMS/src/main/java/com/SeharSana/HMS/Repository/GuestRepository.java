package com.SeharSana.HMS.Repository;

import com.SeharSana.HMS.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {

    Guest findGuestById(Long guestId);
    Guest findGuestByEmail(String guestEmail);
    List<Guest> findGuestByIdAndEmail(Long guestId, String gusetEmail);

}
