package com.spring.vehicleAssessment.service;

import com.spring.vehicleAssessment.dto.VehicleRequest;
import com.spring.vehicleAssessment.dto.VehicleResponse;

import java.util.List;

public interface VehicleService {

    VehicleResponse addVehicle(VehicleRequest vehicleRequest);

    VehicleResponse updateVehicle(Long id, VehicleRequest vehicleRequest);

    VehicleResponse changeStatus(Long id, String status);

    List<VehicleResponse> getAllVehicle();

    List<VehicleResponse> getActiveVehicles();

    VehicleResponse getVehicleById(Long id);

    void deleteVehicleById(Long id);
}
