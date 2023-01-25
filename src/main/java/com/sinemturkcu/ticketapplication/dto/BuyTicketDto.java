package com.sinemturkcu.ticketapplication.dto;

import lombok.Data;

@Data
public class BuyTicketDto {
    private String userEmail;
    private String seatId;
    private String busId;
}
