package com.hotelreservation.apigateway.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserListInRoomsRequest extends BaseRequest{
    private Long userid;
}