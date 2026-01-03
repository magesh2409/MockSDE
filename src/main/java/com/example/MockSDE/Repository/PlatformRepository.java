package com.example.MockSDE.Repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PlatformRepository {
    public UserRepository userRepository;
    public LoggerRepository loggerRepository;
    public ServiceRepository serviceRepository;
}
