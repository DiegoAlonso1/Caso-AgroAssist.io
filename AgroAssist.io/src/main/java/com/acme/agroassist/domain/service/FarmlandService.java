package com.acme.agroassist.domain.service;

import com.acme.agroassist.domain.model.Farmland;

import java.util.Optional;

public interface FarmlandService {
    Farmland createFarmland(Long farmerId, Farmland farmland);
    Farmland updateFarmland(Long farmerId, Long farmlandId, Farmland farmlandRequest, Optional<Long> newFamerId);
}
