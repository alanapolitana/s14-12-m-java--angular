package com.example.app.service;

import com.example.app.dto.address.AddressDTO;
import com.example.app.dto.address.AddressPublicDataDTO;

import java.util.List;

public interface AddressService {

    void registerAddress (AddressDTO addressDTO);

    List<AddressPublicDataDTO> findAllByUserId(Long id);
}
