package com.sample.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class OrderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int OrderId;
    @OneToOne
    @JoinColumn(name = "Flight")
    FlightBooking flightBooking;
    @OneToOne
    @JoinColumn(name = "User")
    User user;
    int NumberOfSeats;
    
    int flightId,userId;
    public OrderRequest() {
    }
    public OrderRequest(int orderId, FlightBooking flightBooking, User user, int numberOfSeats, int flightId,
            int userId) {
        OrderId = orderId;
        this.flightBooking = flightBooking;
        this.user = user;
        NumberOfSeats = numberOfSeats;
        this.flightId = flightId;
        this.userId = userId;
    }
    
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public int getOrderId() {
        return OrderId;
    }
    public void setOrderId(int orderId) {
        OrderId = orderId;
    }
    public FlightBooking getFlightBooking() {
        return flightBooking;
    }
    public void setFlightBooking(FlightBooking flightBooking) {
        this.flightBooking = flightBooking;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getNumberOfSeats() {
        return NumberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        NumberOfSeats = numberOfSeats;
    }
}
