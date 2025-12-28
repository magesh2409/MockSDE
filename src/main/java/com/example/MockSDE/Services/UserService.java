package com.example.MockSDE.Services;

import com.example.MockSDE.Dto.UserRegistration;
import com.example.MockSDE.Mapper.UserMapper;
import com.example.MockSDE.Models.User;
import com.example.MockSDE.Repository.PlatformRepository;
import com.example.MockSDE.Utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;
    private PlatformRepository platformRepository;

    public UserRegistration.UserRegistrationResponse registerUser(UserRegistration.UserRegistrationRequest data){
        platformRepository.loggerRepository.logger.warn("Registering user with email: " + data.getEmail());

        Optional<User> user = platformRepository.userRepository.findByEmail(data.getEmail());
        if(user.isPresent()){
            return new UserRegistration.UserRegistrationResponse(user.get().getId().toString(), Constants.Registration.USER_EXISTS, true);
        }
        try{
            String password = data.getPassword();
            data.setPassword(passwordEncoder.encode(password));
            User newUser = userMapper.toEntity(data);
            newUser.setCreatedAt(LocalDateTime.now());
            newUser = platformRepository.userRepository.save(newUser);
            return new UserRegistration.UserRegistrationResponse(newUser.getId().toString(), Constants.Registration.SUCCESS, false);
        } catch (Exception e){
            return new UserRegistration.UserRegistrationResponse(null, Constants.Registration.FAILED, false);
        }
    }
}
