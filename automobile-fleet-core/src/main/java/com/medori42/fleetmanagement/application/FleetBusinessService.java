package com.medori42.fleetmanagement.application;
import com.medori42.fleetmanagement.domain.AutomobileEntity;
import com.medori42.fleetmanagement.domain.OwnerClientData;
import com.medori42.fleetmanagement.dto.AutomobileResponseDto;
import com.medori42.fleetmanagement.persistence.AutomobileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
@Service
public class FleetBusinessService {
    private static final String CLIENT_SERVICE_BASE_URL = "http://localhost:8888/CLIENT-MANAGEMENT-SERVICE";
    private final AutomobileDataRepository automobileRepository;
    private final RestTemplate httpRestTemplate;
    @Autowired
    public FleetBusinessService(AutomobileDataRepository automobileRepository, RestTemplate httpRestTemplate) {
        this.automobileRepository = automobileRepository;
        this.httpRestTemplate = httpRestTemplate;
    }
    public List<AutomobileResponseDto> retrieveAllAutomobiles() {
        List<AutomobileEntity> automobileList = automobileRepository.findAll();
        ResponseEntity<OwnerClientData[]> clientServiceResponse = httpRestTemplate.getForEntity(
                CLIENT_SERVICE_BASE_URL + "/api/client",
                OwnerClientData[].class);
        OwnerClientData[] ownerDataArray = clientServiceResponse.getBody();
        return automobileList.stream()
                .map(automobile -> convertToResponseDto(automobile, ownerDataArray))
                .toList();
    }
    public AutomobileResponseDto retrieveAutomobileById(Long automobileId) throws Exception {
        AutomobileEntity automobile = automobileRepository.findById(automobileId)
                .orElseThrow(() -> new Exception("Identifiant véhicule invalide: " + automobileId));
        OwnerClientData ownerData = httpRestTemplate.getForObject(
                CLIENT_SERVICE_BASE_URL + "/api/client/" + automobile.getOwnerClientId(),
                OwnerClientData.class);
        return buildAutomobileResponse(automobile, ownerData);
    }
    private AutomobileResponseDto convertToResponseDto(AutomobileEntity automobile, OwnerClientData[] ownerDataArray) {
        OwnerClientData matchingOwner = Arrays.stream(ownerDataArray)
                .filter(owner -> owner.getOwnerIdentifier().equals(automobile.getOwnerClientId()))
                .findFirst()
                .orElse(null);
        return buildAutomobileResponse(automobile, matchingOwner);
    }
    private AutomobileResponseDto buildAutomobileResponse(AutomobileEntity automobile, OwnerClientData ownerData) {
        return AutomobileResponseDto.builder()
                .automobileIdentifier(automobile.getAutomobileId())
                .manufacturerName(automobile.getManufacturerBrand())
                .ownerInformation(ownerData)
                .registrationPlate(automobile.getLicensePlateNumber())
                .modelName(automobile.getModelDesignation())
                .build();
    }
}