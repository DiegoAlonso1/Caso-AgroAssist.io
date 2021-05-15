package com.acme.agroassist.service;

import com.acme.agroassist.domain.model.Farmer;
import com.acme.agroassist.domain.model.Farmland;
import com.acme.agroassist.domain.repository.FarmerRepository;
import com.acme.agroassist.domain.repository.FarmlandRepository;
import com.acme.agroassist.domain.service.FarmlandService;
import com.acme.agroassist.exception.FarmlandSameLocationException;
import com.acme.agroassist.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FarmlandServiceImpl implements FarmlandService {
    @Autowired
    private FarmlandRepository farmlandRepository;
    @Autowired
    private FarmerRepository farmerRepository;

    @Override
    public Farmland createFarmland(Long farmerId, Farmland farmland) {
        //Check
        Optional<Farmland> withSameLocation = farmlandRepository.findByAltitudeAndLatitudeAndLongitude(farmland.getAltitude(),
                farmland.getLatitude(), farmland.getLongitude());
//        if (farmlandRepository.existsByAltitudeAndLatitudeAndLongitude(farmland.getAltitude(),
//                farmland.getLatitude(), farmland.getLongitude()))
//            throw new FarmlandSameLocationException();

        //Create
        return farmerRepository.findById(farmerId).map(farmer -> {
            farmland.setFarmer(farmer);
            return farmlandRepository.save(farmland);
        }).orElseThrow(() -> new ResourceNotFoundException("Farmer", "Id", farmerId));
    }

    @Override
    public Farmland updateFarmland(Long farmerId, Long farmlandId, Farmland farmlandRequest, Optional<Long> newFamerId) {
        //Checks
        Farmland currentFarmland = farmlandRepository.findByIdAndFarmerId(farmlandId, farmerId)
                .orElseThrow(() -> new ResourceNotFoundException("Farmland not found with Id: " + farmlandId + "and FarmerId: " + farmerId));

        Optional<Farmland> withSameLocation = farmlandRepository.findByAltitudeAndLatitudeAndLongitude(
                farmlandRequest.getAltitude(), farmlandRequest.getLatitude(), farmlandRequest.getLongitude());

        //Check sameLocation
        if (withSameLocation.isPresent()){
            if (withSameLocation.get() != currentFarmland)
                throw new FarmlandSameLocationException();
        }

        //Update
        return farmlandRepository.findByIdAndFarmerId(farmlandId, farmerId).map(farmland -> {
            farmland.setAltitude(farmlandRequest.getAltitude())
                .setLatitude(farmlandRequest.getLatitude())
                .setLongitude(farmlandRequest.getLongitude())
                .setLength(farmlandRequest.getLength())
                .setWidth(farmlandRequest.getWidth());

            //Check newFarmer
            if (newFamerId.isPresent()){
                if (farmerRepository.existsById(newFamerId.get())) {
                    farmland.setFarmer(farmerRepository.findById(newFamerId.get()).orElseThrow());
                }
            }

            return farmlandRepository.save(farmland);
        }).orElseThrow(() -> new ResourceNotFoundException("Farmland", "Id", farmlandId));
    }
}
