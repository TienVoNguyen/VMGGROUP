package com.vmg.vont.service;

import com.vmg.vont.payload.request.LoginRequest;
import com.vmg.vont.payload.request.SignupRequest;
import com.vmg.vont.payload.response.JwtResponse;
import com.vmg.vont.payload.response.MessageResponse;

public interface IUserService {
    JwtResponse authenticateUser(LoginRequest loginRequest);
    MessageResponse registerUser(SignupRequest signUpRequest);
}
