package com.panos.it21848;

public class User{
    private String userid,timestamp;
    private float longitude,latitude;
    public User(String userid,float longitude,float latitude,String timestamp){
        this.userid=userid;
        this.timestamp=timestamp;
        this.longitude=longitude;
        this.latitude=latitude;
    }
    public void setUserid(String userid){
        this.userid=userid;
    }
    public void setTimestamp(String timestamp){
        this.timestamp=timestamp;
    }
    public void setLongitude(float longitude){
        this.longitude=longitude;
    }
    public void setLatitude(float latitude){
        this.latitude=latitude;
    }
    public String getUserid(){
        return userid;
    }
    public String getTimestamp(){
        return timestamp;
    }
    public float getLongitude(){
        return longitude;
    }
    public float getLatitude(){
        return latitude;
    }
    @Override
    public String toString(){
        return "User{"+"userid='"+userid+'\''+", timestamp='"+timestamp+'\''+", longitude="+longitude+", latitude="+latitude+'}';
    }
}