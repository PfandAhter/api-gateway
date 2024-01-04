package com.hotelreservation.apigateway.rest.apicall.interfaces;

import com.hotelreservation.apigateway.request.AddBalanceRequest;
import com.hotelreservation.apigateway.request.BaseRequest;
import com.hotelreservation.apigateway.response.BaseResponse;
import com.hotelreservation.apigateway.response.GetBalanceResponse;
import com.hotelreservation.apigateway.rest.exception.AuthException;

public interface IBalanceServiceCall {

    BaseResponse addBalanceRequest(AddBalanceRequest addBalanceRequest);

    GetBalanceResponse getBalance(BaseRequest request) throws AuthException;
}
