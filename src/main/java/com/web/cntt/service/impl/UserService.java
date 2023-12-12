package com.web.cntt.service.impl;

import com.web.cntt.dto.*;
import com.web.cntt.model.User;
import com.web.cntt.repository.UserRepository;
import com.web.cntt.service.IUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDTO getUserInfo(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDTO.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setGender(user.getGender());
        userDTO.setAddress(user.getAddress());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        return userDTO;
    }

    @Override
    public void changeUserInfo(User user, ChangeInfoDTO userDTO) {
        User result = userRepository.findUserByEmail(user.getEmail());
        try {
            if (result != null) {
                result.setFirstName(userDTO.getFirstName());
                result.setAddress(userDTO.getAddress());
                result.setGender(userDTO.getGender());
                result.setDateOfBirth(Date.valueOf(userDTO.getDateOfBirth()));
                result.setLastName(user.getLastName());
                userRepository.save(result);
                System.out.println("Update success");
            }else {
                System.out.println("Update fail");
            }
        }catch (Exception e) {
            throw new RuntimeException("Không thể tải user info");
        }
    }

    @Override
    public ResponseMessage changeUserPassword(User user, ChangePassword changePassword) {
        ResponseMessage responseMessage = new ResponseMessage();
        if(user.getPassword().equals(passwordEncoder.encode(changePassword.getOldPassword()))){
            user.setPassword(changePassword.getNewPassword());
            userRepository.save(user);
            responseMessage.setResult("Update success");
        }else {
            responseMessage.setResult("Password is wrong");
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage resetPassword(User user, ResetPassword resetPassword) {
        return null;
    }

    @Override
    public List<User> getAllAccount() {
        return userRepository.findAll();
    }

    @Override
    public ResponseMessage deleteAccount(String userId) {
        UUID id = UUID.fromString(userId);
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
        ResponseMessage responseMessage = new ResponseMessage();
        userRepository.delete(user);
        responseMessage.setResult("Delete success");
        return responseMessage;
    }
}
