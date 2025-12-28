package com.example.MockSDE.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerRepository {
    public final Logger logger = LoggerFactory.getLogger(LoggerRepository.class);
}
