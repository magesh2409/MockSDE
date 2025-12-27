package com.example.MockSDE.Services;

import com.example.MockSDE.Dto.UserRegistration;
import com.example.MockSDE.Mapper.UserMapper;
import com.example.MockSDE.Models.User;
import com.example.MockSDE.Repository.UserRepository;
import com.example.MockSDE.Utils.ResponseConstants;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;

    public UserRegistration.UserRegistrationResponse registerUser(UserRegistration.UserRegistrationRequest data){
        Optional<User> user = userRepository.findByEmail(data.getEmail());
        if(user.isPresent()){
            return new UserRegistration.UserRegistrationResponse(user.get().getId().toString(), ResponseConstants.Registration.USER_EXISTS, true);
        }
        try{
            String password = data.getPassword();
            data.setPassword(passwordEncoder.encode(password));
            User newUser = userMapper.toEntity(data);
            newUser.setCreatedAt(LocalDateTime.now());
            newUser = userRepository.save(newUser);
            return new UserRegistration.UserRegistrationResponse(newUser.getId().toString(), ResponseConstants.Registration.SUCCESS, false);
        } catch (Exception e){
            return new UserRegistration.UserRegistrationResponse(null, ResponseConstants.Registration.FAILED, false);
        }
    }
}
