package com.acme.agroassist.service;

import com.acme.agroassist.domain.model.Farmer;
import com.acme.agroassist.domain.repository.FarmerRepository;
import com.acme.agroassist.domain.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerServiceImpl implements FarmerService {
    @Autowired
    FarmerRepository farmerRepository;

    @Override
    public Farmer createFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }
}
