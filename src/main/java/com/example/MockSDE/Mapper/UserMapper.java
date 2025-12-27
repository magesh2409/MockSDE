package com.example.MockSDE.Mapper;

import com.example.MockSDE.Dto.UserRegistration;
import com.example.MockSDE.Models.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRegistration.UserRegistrationRequest dto);
}
