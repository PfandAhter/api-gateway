package com.hotelreservation.apigateway.rest.apicall;

import com.hotelreservation.apigateway.lib.constants.Constants;
import com.hotelreservation.apigateway.model.dto.RoomDTO;
import com.hotelreservation.apigateway.request.BaseRequest;
import com.hotelreservation.apigateway.request.BuyRoomRequest;
import com.hotelreservation.apigateway.request.SetCheckInRequest;
import com.hotelreservation.apigateway.request.UserListInRoomsRequest;
import com.hotelreservation.apigateway.response.BaseResponse;
import com.hotelreservation.apigateway.response.BuyRoomResponse;
import com.hotelreservation.apigateway.response.UserListInRoomsResponse;
import com.hotelreservation.apigateway.rest.apicall.interfaces.IRoomServiceCall;
import com.hotelreservation.apigateway.rest.exception.AuthException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class RoomServiceCallImpl implements IRoomServiceCall {
    private final RestTemplate restTemplate;

    @Override
    public List<RoomDTO> findAllAvailableRooms(BaseRequest request) {
        return restTemplate.postForObject("http://localhost:8086/roomreservationservice/roomlist",request, ArrayList.class);
    }

    @Override
    public BuyRoomResponse buyRoom (BuyRoomRequest request) throws AuthException{
        if(restTemplate.postForObject("http://localhost:8090/validate/buyroom",request, Boolean.class)){
            return restTemplate.postForObject("http://localhost:8086/roomreservationservice/buyroom",request, BuyRoomResponse.class);
        }else{
            throw new AuthException(Constants.SERVICE_UNAVAILABLE);
        }
    }

    @Override
    public UserListInRoomsResponse getUserListInRooms (UserListInRoomsRequest request) throws AuthException{
        if(restTemplate.postForObject("http://localhost:8090/validate/ismanager",request,Boolean.class)){
            return restTemplate.postForObject("http://localhost:8086/roomreservationservice/getuserlistinrooms",request, UserListInRoomsResponse.class);
        }else{
            throw new AuthException(Constants.SERVICE_UNAVAILABLE);
        }
    }

    @Override
    public BaseResponse setCheckIn (SetCheckInRequest request) throws AuthException{
        if(restTemplate.postForObject("http://localhost:8090/validate/ismanager",request,Boolean.class)){
            return restTemplate.postForObject("http://localhost:8086/roomreservationservice/setcheckin",request, BaseResponse.class);
        }else {
            throw new AuthException(Constants.SERVICE_UNAVAILABLE);
        }
    }

}
