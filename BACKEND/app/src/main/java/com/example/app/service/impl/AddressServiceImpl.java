package com.example.app.service.impl;

import com.example.app.dto.address.AddressDTO;
import com.example.app.exception.user.UserNotFoundException;
import com.example.app.mapper.AddressMapper;
import com.example.app.repository.AddressRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    private final UserRepository userRepository;

    @Override
    public void registerAddress(AddressDTO addressDTO) {

        Long id = addressDTO.user().id();

        this.userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException
                        ("El usuario con id "+id+" no se encuentra registrado"));

        addressRepository.save(this.addressMapper.toEntity(addressDTO));
    }
}
