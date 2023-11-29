package com.web.cntt.service;

import com.web.cntt.dto.*;
import com.web.cntt.model.User;

import java.util.List;

public interface IUserService {
    UserDTO getUserInfo(User user);

    void changeUserInfo(User user, ChangeInfoDTO userDTO);

    ResponseMessage changeUserPassword(User user, ChangePassword changePassword);

    ResponseMessage resetPassword(User user, ResetPassword resetPassword);

    List<UserDTO> getAllAccount();
}
