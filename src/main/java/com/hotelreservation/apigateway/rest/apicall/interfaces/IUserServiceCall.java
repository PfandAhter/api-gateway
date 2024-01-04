package com.hotelreservation.apigateway.rest.apicall.interfaces;

import com.hotelreservation.apigateway.request.AuthUserRequest;
import com.hotelreservation.apigateway.request.UserAddRequest;
import com.hotelreservation.apigateway.response.AuthUserResponse;
import com.hotelreservation.apigateway.response.BaseResponse;
import com.hotelreservation.apigateway.rest.exception.AuthException;


public interface IUserServiceCall {

    AuthUserResponse authUserServiceCall(AuthUserRequest request) throws AuthException;

    BaseResponse registerUser(UserAddRequest request) throws AuthException;

}
