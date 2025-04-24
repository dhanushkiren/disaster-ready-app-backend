package com.example.DRbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "requests")
public class Request {

    @Id
    private String id;

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

    @Getter
    @Setter
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
