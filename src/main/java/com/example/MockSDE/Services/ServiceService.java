package com.example.MockSDE.Services;

import com.example.MockSDE.Dto.ServiceDto;
import com.example.MockSDE.Exception.DataNotFound;
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

    public void createService(ServiceDto.CreateService dto) throws Exception {
        com.example.MockSDE.Models.Service service = serviceMapper.toEntity(dto);
        platformRepository.serviceRepository.save(service);
        return;
    }

    public void updateService(ObjectId serviceId, ServiceDto.UpdateService dto) throws Exception{
        com.example.MockSDE.Models.Service service = platformRepository.serviceRepository.findById(serviceId).orElseThrow(() -> new Exception("Service not found"));
        service.setUpdatedAt(LocalDateTime.now());
        serviceMapper.updateEntity(dto, service);
        platformRepository.serviceRepository.save(service);
        return;
    }

    public void deleteService(ObjectId serviceId) throws Exception {
        platformRepository.serviceRepository.deleteById(serviceId);
        return;
    }

    public ServiceDto.GetServiceResponse getService(ObjectId serviceId) throws Exception {
        com.example.MockSDE.Models.Service service = platformRepository.serviceRepository.findById(serviceId).orElseThrow(() -> new DataNotFound("Service not found for Id: " + serviceId.toHexString()));
        return serviceMapper.toDto(service);
    }
}
