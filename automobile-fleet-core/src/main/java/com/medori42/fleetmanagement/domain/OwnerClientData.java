package com.medori42.fleetmanagement.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerClientData {
    private Long ownerIdentifier;
    private String ownerFullName;
    private Integer ownerAge;
}