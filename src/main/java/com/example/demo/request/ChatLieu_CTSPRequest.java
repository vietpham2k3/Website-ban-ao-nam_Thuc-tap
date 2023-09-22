package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ChatLieu_CTSPRequest {
    private Integer IdChatLieu;
    private UUID IdCTSP;
}
