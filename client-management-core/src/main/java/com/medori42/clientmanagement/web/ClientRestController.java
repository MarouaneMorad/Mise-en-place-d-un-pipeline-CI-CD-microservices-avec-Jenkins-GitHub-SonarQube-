package com.medori42.clientmanagement.web;
import com.medori42.clientmanagement.domain.ClientEntity;
import com.medori42.clientmanagement.application.ClientBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/client")
public class ClientRestController {
    private final ClientBusinessService clientBusinessService;
    @Autowired
    public ClientRestController(ClientBusinessService clientBusinessService) {
        this.clientBusinessService = clientBusinessService;
    }
    @GetMapping
    public List<ClientEntity> getAllClients() {
        return clientBusinessService.retrieveAllClients();
    }
    @GetMapping("/{id}")
    public ClientEntity getClientById(@PathVariable("id") Long clientIdentifier) throws Exception {
        return clientBusinessService.retrieveClientById(clientIdentifier);
    }
    @PostMapping
    public ResponseEntity<Void> createNewClient(@RequestBody ClientEntity clientData) {
        clientBusinessService.registerNewClient(clientData);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}