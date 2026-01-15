package com.example.MockSDE.Controller;

import com.example.MockSDE.Dto.ServiceDto;
import com.example.MockSDE.Services.ServiceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user/{userId}/service")
public class ServiceController {

    private ServiceService serviceService;


    @GetMapping("{serviceId}")
    public ResponseEntity<ServiceDto.GetServiceResponse> getServiceById(
            @PathVariable("userId") ObjectId userId,
            @PathVariable("serviceId") ObjectId serviceId) throws Exception {
        ServiceDto.GetServiceResponse response = serviceService.getService(serviceId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createService(
            @PathVariable("userId") ObjectId userId,
            @Valid @RequestBody ServiceDto.CreateService payload) throws Exception {
        serviceService.createService(payload);
        return ResponseEntity.status(HttpStatus.OK).body(Collections.emptyMap());
    }

    @PatchMapping("{serviceId}")
    public ResponseEntity<Map<String, Object>> updateService(
            @PathVariable("userId") ObjectId userId,
            @PathVariable("serviceId") ObjectId serviceId,
            @Valid @RequestBody ServiceDto.UpdateService payload) throws Exception {
        serviceService.updateService(serviceId, payload);
        return ResponseEntity.status(HttpStatus.OK).body(Collections.emptyMap());
    }

    @DeleteMapping("{serviceId}")
    public ResponseEntity<Map<String, Object>> deleteService(
            @PathVariable("userId") ObjectId userId,
            @PathVariable("serviceId") ObjectId serviceId) throws Exception {
        serviceService.deleteService(serviceId);
        return ResponseEntity.status(HttpStatus.OK).body(Collections.emptyMap());
    }

}
