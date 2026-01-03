package com.example.MockSDE.Controller;

import com.example.MockSDE.Dto.ServiceDto;
import com.example.MockSDE.Services.ServiceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/service")
public class ServiceController {

    private ServiceService serviceService;


    @GetMapping("{serviceId}")
    public ResponseEntity<ServiceDto.GetServiceResponse> getServiceById(@PathVariable("serviceId") ObjectId serviceId) {
        ServiceDto.GetServiceResponse response = serviceService.getService(serviceId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ServiceDto.ServiceResponse> createService(@RequestBody ServiceDto.CreateService payload) {
        ServiceDto.ServiceResponse response = serviceService.createService(payload);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("{serviceId}")
    public ResponseEntity<ServiceDto.ServiceResponse> updateService(@PathVariable("serviceId") ObjectId serviceId, @Valid @RequestBody ServiceDto.UpdateService payload){
        ServiceDto.ServiceResponse response = serviceService.updateService(serviceId, payload);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("{serviceId}")
    public ResponseEntity<ServiceDto.ServiceResponse> deleteService(@PathVariable("serviceId") ObjectId serviceId) {
        ServiceDto.ServiceResponse response = serviceService.deleteService(serviceId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
