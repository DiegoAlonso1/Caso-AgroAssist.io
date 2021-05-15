package com.acme.agroassist.domain.repository;

import com.acme.agroassist.domain.model.Farmland;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmlandRepository extends JpaRepository<Farmland, Long> {
    Optional<Farmland> findByAltitudeAndLatitudeAndLongitude(Long altitude, Long latitude, Long longitude);
    Optional<Farmland> findByIdAndFarmerId(Long farmlandId, Long farmerId);
}
