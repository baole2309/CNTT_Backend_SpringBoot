package com.web.cntt.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedResp {
    private String token;
}
