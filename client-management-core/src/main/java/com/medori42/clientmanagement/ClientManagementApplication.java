package com.medori42.clientmanagement;
import com.medori42.clientmanagement.domain.ClientEntity;
import com.medori42.clientmanagement.persistence.ClientDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class ClientManagementApplication {
    @Bean
    CommandLineRunner loadInitialData(ClientDataRepository clientDataRepository) {
        return commandLineArgs -> {
            clientDataRepository.save(new ClientEntity(1L, "Amine SAFI", 23.0f));
            clientDataRepository.save(new ClientEntity(2L, "Amal ALAOUI", 22.0f));
            clientDataRepository.save(new ClientEntity(3L, "Samir RAMI", 22.0f));
        };
    }
    public static void main(String[] applicationArgs) {
        SpringApplication.run(ClientManagementApplication.class, applicationArgs);
    }
}