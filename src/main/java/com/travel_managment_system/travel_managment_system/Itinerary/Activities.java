package com.travel_managment_system.travel_managment_system.Itinerary;

public class Activities {
    private String location;
    private String startTime;
    private String endTime;
    private String Img;

    public Activities (String location,String StartTime, String EndTime, String img){
        this.location = location;
        this.startTime = StartTime;
        this.endTime = EndTime;
        this.Img = img;
    }

    public String getImg() {
        return Img;
    }
    public void setImg(String img) {
        Img = img;
    }
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}