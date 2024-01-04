package com.hotelreservation.apigateway.rest.controller;


import com.hotelreservation.apigateway.request.AuthUserRequest;
import com.hotelreservation.apigateway.request.UserAddRequest;
import com.hotelreservation.apigateway.response.AuthUserResponse;
import com.hotelreservation.apigateway.response.BaseResponse;
import com.hotelreservation.apigateway.rest.apicall.UserServiceCallImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/user")
@Slf4j
public class UserController {
    private final UserServiceCallImpl userServiceCall;

    @PostMapping(path = "/login")
    public ResponseEntity<AuthUserResponse> authUser (@NonNull @RequestBody AuthUserRequest request) throws Exception{
        return ResponseEntity.ok(userServiceCall.authUserServiceCall(request));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<BaseResponse> registerUser (@NonNull @RequestBody UserAddRequest request) throws Exception{
        return ResponseEntity.ok(userServiceCall.registerUser(request));
    }

}
