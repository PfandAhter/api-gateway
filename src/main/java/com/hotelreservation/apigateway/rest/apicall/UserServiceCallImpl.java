package com.hotelreservation.apigateway.rest.apicall;


import com.hotelreservation.apigateway.lib.constants.Constants;
import com.hotelreservation.apigateway.request.AuthUserRequest;
import com.hotelreservation.apigateway.request.UserAddRequest;
import com.hotelreservation.apigateway.response.AuthUserResponse;
import com.hotelreservation.apigateway.response.BaseResponse;
import com.hotelreservation.apigateway.rest.apicall.interfaces.IUserServiceCall;
import com.hotelreservation.apigateway.rest.exception.AuthException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j

public class UserServiceCallImpl implements IUserServiceCall {

    private final RestTemplate restTemplate;

    @Override
    public AuthUserResponse authUserServiceCall(AuthUserRequest request) throws AuthException {
        if(restTemplate.postForObject("http://localhost:8090/validate/login",request, Boolean.class)){
            return restTemplate.postForObject("http://localhost:8081/auth/login",request,AuthUserResponse.class);
        }else{
            throw new AuthException(Constants.SERVICE_UNAVAILABLE);
        }
    }

    @Override
    public BaseResponse registerUser(UserAddRequest request) throws AuthException{
        if(restTemplate.postForObject("http://localhost:8090/validate/register",request, Boolean.class)) {
            return restTemplate.postForObject("http://localhost:8081/auth/register",request,BaseResponse.class);
        }else{
            throw new AuthException(Constants.SERVICE_UNAVAILABLE);
        }
    }
}
