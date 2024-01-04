package com.hotelreservation.apigateway.rest.apicall.interfaces;

import com.hotelreservation.apigateway.model.dto.RoomDTO;
import com.hotelreservation.apigateway.request.BaseRequest;
import com.hotelreservation.apigateway.request.BuyRoomRequest;
import com.hotelreservation.apigateway.request.SetCheckInRequest;
import com.hotelreservation.apigateway.request.UserListInRoomsRequest;
import com.hotelreservation.apigateway.response.BaseResponse;
import com.hotelreservation.apigateway.response.BuyRoomResponse;
import com.hotelreservation.apigateway.response.UserListInRoomsResponse;
import com.hotelreservation.apigateway.rest.exception.AuthException;

import java.util.List;

public interface IRoomServiceCall {
    List<RoomDTO> findAllAvailableRooms(BaseRequest request);

    BuyRoomResponse buyRoom (BuyRoomRequest request) throws AuthException;

    UserListInRoomsResponse getUserListInRooms (UserListInRoomsRequest request) throws AuthException;

    BaseResponse setCheckIn (SetCheckInRequest request) throws AuthException;
}

