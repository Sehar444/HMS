package com.SeharSana.HMS.Utility;

public enum EnRoomType {
    BALCONY(1,"Balcony"),
    BAlCONY(2,"Balcony"),
//    BALCONY(3,"Balcony"),
//    BAlCONY(4,"Balcony"),
    BUSINESS(1,"Business"),
    LUXURY(1,"LUXURY");
    private int val;
    private String strValue;
    EnRoomType(int val, String strValue)
    {
        this.val = val;
        this.strValue = strValue;
    }
    public  String getRoomType()
    {
        return  strValue;
    }
    public int getVal()
    {
        return val;
    }
}
