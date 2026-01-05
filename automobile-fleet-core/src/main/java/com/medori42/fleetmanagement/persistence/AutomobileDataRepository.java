package com.medori42.fleetmanagement.persistence;
import com.medori42.fleetmanagement.domain.AutomobileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AutomobileDataRepository extends JpaRepository<AutomobileEntity, Long> {
}