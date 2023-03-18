package com.SeharSana.HMS.Repository;

import com.SeharSana.HMS.entity.SpecialRequirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialRequirementsRepository extends JpaRepository<SpecialRequirements,Long> {
}
