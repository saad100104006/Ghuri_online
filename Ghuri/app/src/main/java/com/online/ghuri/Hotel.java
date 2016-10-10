package com.online.ghuri;

/**
 * Created by saad on 9/28/16.
 */
public class Hotel {

    private String id;
    private String title;
    private String featured_image_url;
    private String displayLocation;
    private String rateMin;
    private String distance;

    public String getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(String displayLocation) {
        this.displayLocation = displayLocation;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFeatured_image_url() {
        return featured_image_url;
    }

    public void setFeatured_image_url(String featured_image_url) {
        this.featured_image_url = featured_image_url;
    }

    public String getRateMin() {
        return rateMin;
    }

    public void setRateMin(String rateMin) {
        this.rateMin = rateMin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
