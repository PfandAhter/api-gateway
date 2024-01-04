package com.hotelreservation.apigateway.rest.apicall;

import com.hotelreservation.apigateway.lib.constants.Constants;
import com.hotelreservation.apigateway.model.entity.User;
import com.hotelreservation.apigateway.repository.UserRepository;
import com.hotelreservation.apigateway.request.AddBalanceRequest;
import com.hotelreservation.apigateway.request.BaseRequest;
import com.hotelreservation.apigateway.response.BaseResponse;
import com.hotelreservation.apigateway.response.GetBalanceResponse;
import com.hotelreservation.apigateway.rest.apicall.interfaces.IBalanceServiceCall;
import com.hotelreservation.apigateway.rest.exception.AuthException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
@Service
@Slf4j

public class BalanceServiceCallImpl implements IBalanceServiceCall {

    private final RestTemplate restTemplate;

//    private final UserRepository userRepository;

    @Override
    public BaseResponse addBalanceRequest(AddBalanceRequest addBalanceRequest) {
        return restTemplate.postForObject("http://localhost:8084/balance/addbalance", addBalanceRequest, BaseResponse.class);
    }

    @Override
    public GetBalanceResponse getBalance(BaseRequest request) throws AuthException {

//        User user = userRepository.findByUsername(restTemplate.postForObject("http://localhost:8082/jwt/extractUsername", request, String.class));

//        ResponseEntity<Boolean> testing = restTemplate.getForEntity("http://localhost:8090/validate/getbalance/" + user.getId(), Boolean.class);

        //testing.getbody(

        if (restTemplate.postForObject("http://localhost:8090/validate/getbalance",request,Boolean.class)) {
            return restTemplate.postForObject("http://localhost:8084/balance/getbalance", request, GetBalanceResponse.class);
        } else {
            throw new AuthException(Constants.SERVICE_UNAVAILABLE);
        }
    }
}
