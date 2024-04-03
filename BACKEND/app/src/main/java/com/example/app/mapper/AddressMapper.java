package com.example.app.mapper;

import com.example.app.dto.AddressDTO;
import com.example.app.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface AddressMapper {

    Address toEntity(AddressDTO addressDTO);
}
