package com.workintech.s18d4.controller;


import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
@Data
public class CustomerController {
    private CustomerService customerService;

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer find(@PathVariable Long id) {
        return customerService.find(id);
    }

    @PostMapping
    public CustomerResponse save(@RequestBody Customer customer) {
        if(customer == null){
            return null;
        }
        Customer savedCustomer = customerService.save(customer);
        return new  CustomerResponse(savedCustomer.getId(),savedCustomer.getEmail(),savedCustomer.getSalary());
    }


    @DeleteMapping("/{id}")
    public CustomerResponse deleteById(@PathVariable Long id) {
        Customer customer = customerService.find(id);
        customerService.delete(id);
        return new  CustomerResponse(customer.getId(),customer.getEmail(),customer.getSalary());
    }
}
