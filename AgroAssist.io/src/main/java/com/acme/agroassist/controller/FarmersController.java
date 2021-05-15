package com.acme.agroassist.controller;

import com.acme.agroassist.domain.model.Farmer;
import com.acme.agroassist.domain.service.FarmerService;
import com.acme.agroassist.resource.FarmerResource;
import com.acme.agroassist.resource.SaveFarmerResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/farmers")
public class FarmersController {
    @Autowired
    private FarmerService farmerService;
    @Autowired
    private ModelMapper mapper;


    //POST FARMER
    @Operation(summary = "Post Farmer", description = "Create a Farmer", tags = {"Farmers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Farmer created", content = @Content(mediaType =
                    "application/json"))
    })
    @PostMapping
    public FarmerResource createFarmer(@Valid @RequestBody SaveFarmerResource resource){
        Farmer farmer = convertToEntity(resource);
        return convertToResource(farmerService.createFarmer(farmer));
    }


    private Farmer convertToEntity(SaveFarmerResource resource) {
        return mapper.map(resource, Farmer.class);
    }

    private FarmerResource convertToResource(Farmer entity) {
        return mapper.map(entity, FarmerResource.class);
    }
}
