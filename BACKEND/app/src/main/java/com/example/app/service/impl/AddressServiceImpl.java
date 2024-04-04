package com.example.app.service.impl;

import com.example.app.dto.address.AddressDTO;
import com.example.app.dto.address.AddressPublicDataDTO;
import com.example.app.exception.user.UserNotFoundException;
import com.example.app.mapper.AddressMapper;
import com.example.app.model.Address;
import com.example.app.repository.AddressRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void registerAddress(AddressDTO addressDTO) {

        Long id = addressDTO.user().id();

        this.userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException
                        ("El usuario con id "+id+" no se encuentra registrado"));

        addressRepository.save(this.addressMapper.toEntity(addressDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressPublicDataDTO> findAllByUserId(Long id) {

        this.userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException
                        ("El usuario con id "+id+" no se encuentra registrado"));

       List<Address> addresses = this.addressRepository.findAllByUserId(id);

        return this.addressMapper.toAddressPublicDataDTO(addresses);
    }
}
