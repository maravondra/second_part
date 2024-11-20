package de.engeto.springbootindocker.repository;

import de.engeto.springbootindocker.repository.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByFirstName(String firstName);

    @Query(value = "SELECT c from Customer c where c.lastName = :name")
    List<Customer> findCustomerAccordingToSecondName(@Param("name") String lastName);
}
