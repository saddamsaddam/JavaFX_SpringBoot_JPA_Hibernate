package org.example.spring;

import org.springframework.data.jpa.repository.JpaRepository;
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    // Add custom queries if needed
}
