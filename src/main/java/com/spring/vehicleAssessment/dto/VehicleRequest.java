package com.spring.vehicleAssessment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleRequest {

    @NotBlank
    @NotNull(message = "vehicle name should be provided.")
    private String vehicleName;
    private String model;
    private String color;
    private Boolean isActive;



}
