package com.SeharSana.HMS.Utility;

public enum EnRoomType {
    BALCONY("Balcony"),
    LUXURY("Luxury"),
    STANDARD("Standard");

    private String roomType;

    EnRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomType() {
        return roomType;
    }

    public static EnRoomType fromString(String text) {
        for (EnRoomType enRoomType : EnRoomType.values()) {
            if (enRoomType.roomType.equalsIgnoreCase(text)) {
                return enRoomType;
            }
        }
        return null;
    }
}
