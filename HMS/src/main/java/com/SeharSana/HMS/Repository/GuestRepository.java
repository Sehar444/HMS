package com.SeharSana.HMS.Repository;

import com.SeharSana.HMS.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Long> {
}
