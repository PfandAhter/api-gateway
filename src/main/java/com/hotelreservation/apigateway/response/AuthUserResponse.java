package com.hotelreservation.apigateway.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserResponse {
    private String token;
}
