package com.sample.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int flightId;
    String flightName;
    String flightOwnedBy;
    int minimumPrice;
    //@JsonProperty("maximumPrice")
    int maximumPrice;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    public FlightBooking() {
    }
    public FlightBooking(int flightId, String flightName, String flightOwnedBy, int minimumPrice, int maximumPrice) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.flightOwnedBy = flightOwnedBy;
        this.minimumPrice = minimumPrice;
        this.maximumPrice = maximumPrice;
    }
    public int getFlightId() {
        return flightId;
    }
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
    public String getFlightName() {
        return flightName;
    }
    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }
    public String getFlightOwnedBy() {
        return flightOwnedBy;
    }
    public void setFlightOwnedBy(String flightOwnedBy) {
        this.flightOwnedBy = flightOwnedBy;
    }
    public int getMinimumPrice() {
        return minimumPrice;
    }
    public void setMinimumPrice(int minimumPrice) {
        this.minimumPrice = minimumPrice;
    }
    public int getMaximumPrice() {
        return maximumPrice;
    }
    public void setMaximumPrice(int maximumPrice) {
        this.maximumPrice = maximumPrice;
    }
    
}
