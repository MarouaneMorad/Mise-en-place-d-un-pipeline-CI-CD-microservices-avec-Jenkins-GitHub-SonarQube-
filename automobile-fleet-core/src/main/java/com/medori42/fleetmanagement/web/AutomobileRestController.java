package com.medori42.fleetmanagement.web;
import com.medori42.fleetmanagement.dto.AutomobileResponseDto;
import com.medori42.fleetmanagement.application.FleetBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("api/automobile")
public class AutomobileRestController {
    private final FleetBusinessService fleetBusinessService;
    @Autowired
    public AutomobileRestController(FleetBusinessService fleetBusinessService) {
        this.fleetBusinessService = fleetBusinessService;
    }
    @GetMapping
    public List<AutomobileResponseDto> getAllAutomobiles() {
        return fleetBusinessService.retrieveAllAutomobiles();
    }
    @GetMapping("/{id}")
    public AutomobileResponseDto getAutomobileById(@PathVariable("id") Long automobileIdentifier) throws Exception {
        return fleetBusinessService.retrieveAutomobileById(automobileIdentifier);
    }
}