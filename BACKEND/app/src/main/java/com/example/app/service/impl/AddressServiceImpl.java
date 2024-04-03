package com.example.app.service.impl;

import com.example.app.dto.AddressDTO;
import com.example.app.mapper.AddressMapper;
import com.example.app.repository.AddressRepository;
import com.example.app.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    @Override
    public void registerAddress(AddressDTO addressDTO) {
        addressRepository.save(addressMapper.toEntity(addressDTO));
    }
}
