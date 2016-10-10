package com.online.ghuri;

/**
 * Created by saad on 6/11/16.
 */


public class room {


    private String roomId;
    private String roomTitle;
    private String roomImage;
    private String persons;
    private String rate;
    private String discountedRate;

    public String getroomId() {
        return roomId;
    }

    public void setroomId(String roomId) {
        this.roomId = roomId;
    }

    public String getroomTitle() {
        return roomTitle;
    }

    public void setroomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getroomImage() {
        return roomImage;
    }

    public void setroomImage(String roomImage) {
        this.roomImage = roomImage;
    }

    public String getpersons() {
        return persons;
    }

    public void setpersons(String persons) {
        this.persons = persons;
    }

    public String getrate() {
        return rate;
    }

    public void setrate(String rate) {
        this.rate = rate;
    }


    public String getdiscountedRate() {
        return discountedRate;
    }

    public void setdiscountedRate(String discountedRate) {
        this.discountedRate = discountedRate;
    }





    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        room other = (room) obj;
        if (roomId != other.roomId)
            return false;
        return true;
    }
}



