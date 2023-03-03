package com.spring.vehicleAssessment.controller;

import com.spring.vehicleAssessment.route.Route;
import com.spring.vehicleAssessment.dto.VehicleRequest;
import com.spring.vehicleAssessment.dto.VehicleResponse;
import com.spring.vehicleAssessment.dto.Message;
import com.spring.vehicleAssessment.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping(value = Route.ADD_VEHICLE)
    public VehicleResponse addVehicle(@RequestBody @Valid VehicleRequest vehicleRequest) {
        return vehicleService.addVehicle(vehicleRequest);
    }

    @PutMapping(value = Route.UPDATE_VEHICLE)
    public VehicleResponse updateVehicle(@PathVariable("id") Long id, @RequestBody @Valid VehicleRequest vehicleRequest) {
        return vehicleService.updateVehicle(id, vehicleRequest);
    }

    @GetMapping(value = Route.GET_ALL)
    public List<VehicleResponse> getAllVehicle() {
        return vehicleService.getAllVehicle();
    }

    @GetMapping(value = Route.GET_BY_ACTIVE)
    public List<VehicleResponse> getActiveVehicles() {
        return vehicleService.getActiveVehicles();
    }

    @GetMapping(value = Route.GET_BY_ID)
    public VehicleResponse getVehicleById(@PathVariable("id") Long id) {
        return vehicleService.getVehicleById(id);
    }

    @DeleteMapping(value = Route.DELETE_BY_ID)
    public Message deleteVehicleById(@PathVariable("id") Long id) {
        vehicleService.deleteVehicleById(id);
        return Message.builder().message("Vehicle deleted successfully").build();
    }

    @PatchMapping(value = Route.ACTIVATE)
    public VehicleResponse activateVehicle(@PathVariable("id") Long id) {
        return vehicleService.changeStatus(id, "ACTIVE");
    }

    @PatchMapping(value = Route.DEACTIVATE)
    public VehicleResponse deactivateVehicle(@PathVariable("id") Long id) {
        return vehicleService.changeStatus(id, "DEACTIVATE");
    }

}
