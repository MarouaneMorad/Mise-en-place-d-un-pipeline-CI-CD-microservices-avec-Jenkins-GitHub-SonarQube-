package com.medori42.fleetmanagement.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "automobiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomobileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "automobile_id")
    private Long automobileId;
    @Column(name = "manufacturer_brand", nullable = false)
    private String manufacturerBrand;
    @Column(name = "model_designation")
    private String modelDesignation;
    @Column(name = "license_plate", unique = true)
    private String licensePlateNumber;
    @Column(name = "owner_client_id")
    private Long ownerClientId;
}