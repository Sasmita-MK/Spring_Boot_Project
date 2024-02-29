package com.sample.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.model.FlightBooking;
import com.sample.demo.model.OrderRequest;
import com.sample.demo.model.User;
import com.sample.demo.repository.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    FlightService flightService;
    @Autowired
    UserService userService;
    //insertOrder
    public OrderRequest insertOrder(OrderRequest orderRequest)
    {
        int flightId = orderRequest.getFlightId();
        int userId = orderRequest.getUserId();
        FlightBooking flightBooking = flightService.getById(flightId);
        User user = userService.getById(userId);
        orderRequest.setFlightBooking(flightBooking);
        orderRequest.setUser(user);
        return orderRepo.save(orderRequest);
    }
    //Read
    public List<OrderRequest> getOrder()
    {
        return orderRepo.findAll();
    }
    //Update
    public boolean updateOrder(int id,OrderRequest o)
    {
        OrderRequest toBeUpdated =  orderRepo.findById(id).orElse(null);
        if(toBeUpdated == null)
        {
            return false;
        }else{
            toBeUpdated.setUserId(o.getUserId());
            toBeUpdated.setFlightBooking(o.getFlightBooking());
            toBeUpdated.setFlightId(o.getFlightId());
            toBeUpdated.setNumberOfSeats(o.getNumberOfSeats());
            toBeUpdated.setUser(o.getUser());
            orderRepo.save(toBeUpdated);
            return true;
        }
    }
    //Delete
    public boolean deleteOrder(int id)
    {
        OrderRequest toBeDeleted = orderRepo.findById(id).orElse(null);
        if(toBeDeleted == null)
        {
            return false;
        }else{
            orderRepo.delete(toBeDeleted);
            return true;
        }
    }
    //GetUserById
    public OrderRequest getById(int id)
    {
        return orderRepo.findById(id).orElse(null);
    }
}
