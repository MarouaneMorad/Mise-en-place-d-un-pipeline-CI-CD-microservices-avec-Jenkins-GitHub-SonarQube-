package com.medori42.fleetmanagement.dto;
import com.medori42.fleetmanagement.domain.OwnerClientData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomobileResponseDto {
    private Long automobileIdentifier;
    private String manufacturerName;
    private String modelName;
    private String registrationPlate;
    private OwnerClientData ownerInformation;
}