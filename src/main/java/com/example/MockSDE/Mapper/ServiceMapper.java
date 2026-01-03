package com.example.MockSDE.Mapper;


import com.example.MockSDE.Dto.ServiceDto;
import com.example.MockSDE.Models.Service;
import org.bson.types.ObjectId;
import org.mapstruct.*;

@Mapper( componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface ServiceMapper {

    Service toEntity(ServiceDto.CreateService dto);

    void updateEntity(ServiceDto.UpdateService dto,  @MappingTarget Service entity);

    ServiceDto.GetServiceResponse toDto(Service service);
    
    default String map(ObjectId objectId) {
        return objectId != null ? objectId.toHexString() : null;
    }
}
