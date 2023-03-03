package com.spring.vehicleAssessment.service.impl;

import com.spring.vehicleAssessment.dto.VehicleRequest;
import com.spring.vehicleAssessment.dto.VehicleResponse;
import com.spring.vehicleAssessment.entity.Vehicle;
import com.spring.vehicleAssessment.repository.VehicleRepository;
import com.spring.vehicleAssessment.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleResponse addVehicle(VehicleRequest vehicleRequest) {
        return toResponse(vehicleRepository.save(toEntity(vehicleRequest)));
    }

    @Override
    public VehicleResponse updateVehicle(Long id, VehicleRequest vehicleRequest) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not valid!!"));
        return toResponse(vehicleRepository.save(toEntity(vehicleRequest, vehicle)));
    }

    @Override
    public List<VehicleResponse> getAllVehicle() {
        return vehicleRepository.findAll()
                .stream()
                .map(vehicle -> toResponse(vehicle))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleResponse getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found!!"));
        return toResponse(vehicle);
    }

    @Override
    public void deleteVehicleById(Long id) {
        if (vehicleRepository.existsById(id)) vehicleRepository.deleteById(id);
        else throw new RuntimeException("Vehicle not found!!");
    }

    @Override
    public List<VehicleResponse> getActiveVehicles() {
        return vehicleRepository.findByIsActive(true)
                .stream()
                .map(vehicle -> toResponse(vehicle))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleResponse changeStatus(Long id, String status) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not valid!!"));
        if (status.equalsIgnoreCase("ACTIVE")) {
            vehicle.setIsActive(true);
        }else {
            vehicle.setIsActive(false);
        }
        return toResponse(vehicleRepository.save(vehicle));
    }

    private Vehicle toEntity(VehicleRequest vehicleRequest) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName(vehicleRequest.getVehicleName());
        vehicle.setModel(vehicleRequest.getModel());
        vehicle.setColor(vehicleRequest.getColor());
        return vehicle;
    }

    public Vehicle toEntity(VehicleRequest vehicleRequest, Vehicle vehicle) {
        if (vehicleRequest.getVehicleName() != null)
            vehicle.setVehicleName(vehicleRequest.getVehicleName());
        if (vehicleRequest.getModel() != null)
            vehicle.setModel(vehicleRequest.getModel());
        if (vehicleRequest.getModel() != null)
            vehicle.setColor(vehicleRequest.getColor());
        return vehicle;
    }

    public VehicleResponse toResponse(Vehicle entity) {
        if (entity != null) {
            return VehicleResponse.builder()
                    .id(entity.getId())
                    .vehicleName(entity.getVehicleName())
                    .model(entity.getModel())
                    .color(entity.getColor())
                    .isActive(entity.getIsActive())
                    .build();
        }
        return VehicleResponse.builder().build();
    }

}
