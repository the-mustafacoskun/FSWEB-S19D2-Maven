package com.workintech.s18d4.controller;


import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController{
    private AddressService addressService;

    @GetMapping
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id)
    {
        return addressService.find(id);
    }

    @PostMapping
    public Address save(@RequestBody Address address)
    {
        return addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public Address delete(@PathVariable Long id)
    {
        return addressService.delete(id);
    }

}
