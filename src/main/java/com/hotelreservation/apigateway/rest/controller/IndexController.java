package com.hotelreservation.apigateway.rest.controller;


import com.hotelreservation.apigateway.model.dto.RoomDTO;
import com.hotelreservation.apigateway.request.*;
import com.hotelreservation.apigateway.response.BaseResponse;
import com.hotelreservation.apigateway.response.BuyRoomResponse;
import com.hotelreservation.apigateway.response.GetBalanceResponse;
import com.hotelreservation.apigateway.response.UserListInRoomsResponse;
import com.hotelreservation.apigateway.rest.apicall.BalanceServiceCallImpl;
import com.hotelreservation.apigateway.rest.apicall.RoomServiceCallImpl;
import com.hotelreservation.apigateway.rest.exception.AuthException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/hotel")
@Slf4j
@RequiredArgsConstructor

public class IndexController {
    private final BalanceServiceCallImpl balanceService;

    private final RoomServiceCallImpl roomServiceCall;

    /*@GetMapping(path = "/getbalance")
    public ResponseEntity<GetBalanceResponse> getBalance(BaseRequest request) throws AuthException {
        return ResponseEntity.ok(balanceService.getBalance(request));
    }*/

    @PostMapping(path = "/getbalance")
    public ResponseEntity<GetBalanceResponse> getBalance(BaseRequest request) throws AuthException {
        return ResponseEntity.ok(balanceService.getBalance(request));
    }

    @PostMapping(path = "/addbalance")
    public ResponseEntity<BaseResponse> addBalance (@NonNull @RequestBody AddBalanceRequest request){
        return ResponseEntity.ok(balanceService.addBalanceRequest(request));
    }

    @GetMapping(path = "/roomlist")
    public ResponseEntity<List<RoomDTO>> getRoomList (BaseRequest request){
        return ResponseEntity.ok(roomServiceCall.findAllAvailableRooms(request));
    }

    @PostMapping(path = "/buyroom")
    public ResponseEntity<BuyRoomResponse> buyRoomRequest(@NonNull @RequestBody BuyRoomRequest request) throws AuthException{
        return ResponseEntity.ok(roomServiceCall.buyRoom(request));
    }

    @PostMapping(path = "/memberlistinroom")
    public ResponseEntity<UserListInRoomsResponse> getMemberListInRooms(@NonNull @RequestBody UserListInRoomsRequest request) throws AuthException{
        return ResponseEntity.ok(roomServiceCall.getUserListInRooms(request));
    }

    @PostMapping(path = "/setcheckin")
    public ResponseEntity<BaseResponse> setCheckIn (@NonNull @RequestBody SetCheckInRequest request) throws AuthException{
        return ResponseEntity.ok(roomServiceCall.setCheckIn(request));
    }
}
