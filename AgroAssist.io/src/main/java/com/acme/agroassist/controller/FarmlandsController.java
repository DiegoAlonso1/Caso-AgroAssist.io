package com.acme.agroassist.controller;

import com.acme.agroassist.domain.model.Farmland;
import com.acme.agroassist.domain.service.FarmlandService;
import com.acme.agroassist.resource.FarmlandResource;
import com.acme.agroassist.resource.SaveFarmlandResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/farmers/{farmerId}/farmlands")
public class FarmlandsController {
    @Autowired
    private FarmlandService farmlandService;
    @Autowired
    private ModelMapper mapper;


    //POST FARMLAND
    @Operation(summary = "Post Farmland", description = "Create a Farmland", tags = {"Farmlands"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Farmland created", content = @Content(mediaType =
                    "application/json"))
    })
    @PostMapping
    public FarmlandResource createFarmland(@PathVariable Long farmerId, @Valid @RequestBody SaveFarmlandResource resource){
        Farmland farmland = convertToEntity(resource);
        return convertToResource(farmlandService.createFarmland(farmerId, farmland));
    }


    //PUT FARMLAND
    @Operation(summary = "Put Farmland", description = "Update a Farmland", tags = {"Farmlands"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Farmland updated", content = @Content(mediaType =
                    "application/json"))
    })
    @PutMapping("/{farmlandId}")
    public FarmlandResource updateFarmland(@PathVariable Long farmerId, @PathVariable Long farmlandId, @RequestBody SaveFarmlandResource resource, Optional<Long> newFarmlandId){
        Farmland farmland = convertToEntity(resource);
        return convertToResource(farmlandService.updateFarmland(farmerId, farmlandId, farmland, newFarmlandId));
    }


    private Farmland convertToEntity(SaveFarmlandResource resource) {
        return mapper.map(resource, Farmland.class);
    }

    private FarmlandResource convertToResource(Farmland entity) {
        return mapper.map(entity, FarmlandResource.class);
    }
}
