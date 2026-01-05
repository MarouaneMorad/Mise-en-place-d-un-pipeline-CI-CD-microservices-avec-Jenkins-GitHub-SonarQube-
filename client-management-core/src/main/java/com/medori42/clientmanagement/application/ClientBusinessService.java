package com.medori42.clientmanagement.application;
import com.medori42.clientmanagement.domain.ClientEntity;
import com.medori42.clientmanagement.persistence.ClientDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ClientBusinessService {
    private final ClientDataRepository clientRepository;
    @Autowired
    public ClientBusinessService(ClientDataRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public List<ClientEntity> retrieveAllClients() {
        return clientRepository.findAll();
    }
    public ClientEntity retrieveClientById(Long clientId) throws Exception {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new Exception("Identifiant client invalide: " + clientId));
    }
    public void registerNewClient(ClientEntity newClient) {
        clientRepository.save(newClient);
    }
}