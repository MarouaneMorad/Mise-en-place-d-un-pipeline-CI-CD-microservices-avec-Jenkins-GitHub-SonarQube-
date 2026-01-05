package com.medori42.clientmanagement.persistence;
import com.medori42.clientmanagement.domain.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientDataRepository extends JpaRepository<ClientEntity, Long> {
}