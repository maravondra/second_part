package de.engeto.springbootindocker.controller;

import de.engeto.springbootindocker.repository.CustomerRepository;
import de.engeto.springbootindocker.repository.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @PutMapping
    public Customer insertNeCustomer(@RequestBody Customer neCustomer){
        Customer save = customerRepository.save(neCustomer);
        return save;
    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @GetMapping("/{firstName}")
    public List<Customer> getCustomerAccordingFirstName(@PathVariable String firstName){
        return customerRepository.findCustomerByFirstName(firstName);
    }

    @GetMapping("/{lastName}")
    public List<Customer> getCutomerAccrodingLastName(@PathVariable String lastName){
        return customerRepository.findCustomerAccordingToSecondName(lastName);
    }

}
