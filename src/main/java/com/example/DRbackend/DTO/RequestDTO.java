package com.example.DRbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class RequestDTO {
    private String id; // Changed from Long to String
    private String name;
    private String contactNumber;
    private String helpType;
    private String landmark;
    private String status;

    public Map<String, Double> getExactLocation() {
        return exactLocation;
    }

    public void setExactLocation(Map<String, Double> exactLocation) {
        this.exactLocation = exactLocation;
    }

    private Map<String, Double> exactLocation; // Change from boolean to Location object


    public static class Location {
        private double lat;
        private double lon;

        public Location() {}

        public Location(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getHelpType() {
        return helpType;
    }

    public void setHelpType(String helpType) {
        this.helpType = helpType;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

//    public Location getExactLocation() {
//        return exactLocation;
//    }
//
//    public void setExactLocation(Location exactLocation) {
//        this.exactLocation = exactLocation;
//    }

}