package com.example.MockSDE.Services;

import com.example.MockSDE.Dto.ServiceDto;
import com.example.MockSDE.Mapper.ServiceMapper;
import com.example.MockSDE.Repository.PlatformRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ServiceService {

    private PlatformRepository platformRepository;
    private ServiceMapper serviceMapper;

    public ServiceDto.ServiceResponse createService(ServiceDto.CreateService dto) {
        try{
            com.example.MockSDE.Models.Service service = serviceMapper.toEntity(dto);
            platformRepository.serviceRepository.save(service);
            return new ServiceDto.ServiceResponse(service.getId(), service.getUserId(), "Service created successfully");
        } catch (Exception e){
            return new ServiceDto.ServiceResponse(null, null, "Service creation failed" + e.getMessage());
        }
    }

    public ServiceDto.ServiceResponse updateService(ObjectId serviceId, ServiceDto.UpdateService dto) {
        try{
            com.example.MockSDE.Models.Service service = platformRepository.serviceRepository.findById(serviceId).orElseThrow(() -> new Exception("Service not found"));
            service.setUpdatedAt(LocalDateTime.now());
            serviceMapper.updateEntity(dto, service);
            platformRepository.serviceRepository.save(service);
            return new ServiceDto.ServiceResponse(service.getId(), service.getUserId(), "Service updated successfully");
        } catch (Exception e){
            return new ServiceDto.ServiceResponse(dto.getId(), dto.getUserId(), "Service update failed: " + e.getMessage());
        }
    }

    public ServiceDto.ServiceResponse deleteService(ObjectId serviceId) {
        try{
            platformRepository.serviceRepository.deleteById(serviceId);
            return new ServiceDto.ServiceResponse(serviceId, null, "Service deleted successfully");
        } catch (Exception e){
            return new ServiceDto.ServiceResponse(serviceId, null, "Service deletion failed: " + e.getMessage());
        }
    }

    public ServiceDto.GetServiceResponse getService(ObjectId serviceId) {
        try {
            com.example.MockSDE.Models.Service service = platformRepository.serviceRepository.findById(serviceId).orElseThrow(() -> new Exception("Service not found"));
            return serviceMapper.toDto(service);
        } catch (Exception e) {
            return serviceMapper.toDto(null);
        }
    }
}
