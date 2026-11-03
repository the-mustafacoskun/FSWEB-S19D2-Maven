package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address find(Long id) {
        Optional<Address> address = addressRepository.findById(id);
       return address.orElse(null);
    }

    @Override
    public Address update(Long id, Address address) {
        Address foundAddress = find(id);
        if (foundAddress != null) {
            foundAddress.setStreet(address.getStreet());
            foundAddress.setCity(address.getCity());
            foundAddress.setCountry(address.getCountry());
            foundAddress.setNo(address.getNo());
            foundAddress.setDescription(address.getDescription());
            return addressRepository.save(foundAddress);
        }
        return null;
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address delete(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if (addressOptional.isPresent()) {
            addressRepository.delete(addressOptional.get());
            return addressOptional.get();
        }
        return null;
    }
}
