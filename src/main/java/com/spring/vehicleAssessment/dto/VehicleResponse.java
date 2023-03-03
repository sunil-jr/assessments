package com.spring.vehicleAssessment.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleResponse {
    private Long id;
    private String vehicleName;
    private String model;
    private Boolean isActive;
    private String color;


}
