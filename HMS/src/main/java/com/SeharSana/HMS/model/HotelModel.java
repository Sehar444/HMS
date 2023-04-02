package com.SeharSana.HMS.model;

import org.springframework.stereotype.Component;

@Component
public class HotelModel {
    private int hotelId;
    private String hotelName;

    private String hotelLocation;

    private Long hotelPhoneNo;
    private String hotelEmail;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = "RoyalPalace Hotel";
    }

    public Long getHotelPhoneNo() {
        return hotelPhoneNo;
    }

    public void setHotelPhoneNo(Long hotelPhoneNo) {
        this.hotelPhoneNo = 9876551122L;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = "royalpalace@gmail.com";
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = "Lahore";
    }





}
