package com.acme.agroassist;

import com.acme.agroassist.domain.model.Farmer;
import com.acme.agroassist.domain.model.Farmland;
import com.acme.agroassist.domain.repository.FarmerRepository;
import com.acme.agroassist.domain.repository.FarmlandRepository;
import com.acme.agroassist.domain.service.FarmlandService;
import com.acme.agroassist.resource.FarmlandResource;
import com.acme.agroassist.service.FarmlandServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class FarmlandServiceImplTest {
    @MockBean
    private FarmerRepository farmerRepository;
    @MockBean
    private FarmlandRepository farmlandRepository;
    @Autowired
    private FarmlandService farmlandService;

    @TestConfiguration
    static class FarmlandServiceImplTestConfiguration {
        @Bean
        public FarmlandService farmlandService(){
            return new FarmlandServiceImpl();
        }
    }

    @Test
    @DisplayName("When UpdateFarmland With NewFarmerId Then Returns Farmland")
    void whenUpdateFarmlandWithNewFarmerIdThenReturnsFarmland(){
        //Arrange
        Long farmerId = 1L;
        Long farmlandId = 1L;
        Farmer farmerTarget = new Farmer().setId(1L);
        Farmland currentFarmland = new Farmland().setId(1L);
        Farmland farmlandRequest = new Farmland();
        Optional<Long> newFarmerId = Optional.of(1L);

        when(farmlandRepository.findByIdAndFarmerId(farmlandId, farmerId)).thenReturn(Optional.of(currentFarmland));
        when(farmlandRepository.findByAltitudeAndLatitudeAndLongitude(farmlandRequest.getAltitude(),
                farmlandRequest.getLatitude(), farmlandRequest.getLongitude())).thenReturn(Optional.empty());
        when(farmerRepository.findById(1L)).thenReturn(Optional.of(farmerTarget));
        when(farmerRepository.existsById(newFarmerId.get())).thenReturn(true);
        when(farmerRepository.findById(newFarmerId.get())).thenReturn(Optional.of(farmerTarget));
        when(farmlandRepository.save(currentFarmland)).thenReturn(currentFarmland);

        //Act
        Farmland foundFarmland = farmlandService.updateFarmland(farmerId, farmlandId, farmlandRequest, newFarmerId);

        //Assert
        assertThat(foundFarmland).isEqualTo(currentFarmland);
    }
}
