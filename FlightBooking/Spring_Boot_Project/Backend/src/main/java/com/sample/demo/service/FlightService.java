package com.sample.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sample.demo.model.FlightBooking;
import com.sample.demo.repository.FlightRepo;


@Service
public class FlightService {
    @Autowired
    FlightRepo flightRepo;
    //Create
    public FlightBooking createFlight(FlightBooking flightBooking)
    {
        return flightRepo.save(flightBooking);
    }
    //Read
    public List<FlightBooking> getFlightBookings()
    {
        return flightRepo.findAll();
    }
    //Update
    public boolean updateFlightBooking(int id,FlightBooking fb)
    {
        FlightBooking toBeUpdated = flightRepo.findById(id).orElse(null);
        if(toBeUpdated == null)
        {
            return false;
        }else{
            toBeUpdated.setFlightName(fb.getFlightName());
            toBeUpdated.setFlightOwnedBy(fb.getFlightOwnedBy());
            toBeUpdated.setMaximumPrice(fb.getMaximumPrice());
            toBeUpdated.setMinimumPrice(fb.getMinimumPrice());
            flightRepo.save(toBeUpdated);
            return true;
        }
    }
    //Delete
    public boolean deleteFlightBooking(int id)
    {
        FlightBooking toBeDeleted = flightRepo.findById(id).orElse(null);
        if(toBeDeleted == null)
        {
            return false;
        }else{
            flightRepo.delete(toBeDeleted);
            return true;
        }
    }
    //getById
    public FlightBooking getById(int id)
    {
        return flightRepo.findById(id).orElse(null);
    }
    //Sorting
    public List<FlightBooking> sortByFlightBookingName(String FlightName)
    {
        Sort sort = Sort.by(FlightName).ascending();
        return (List<FlightBooking>) flightRepo.findAll(sort);
    }
    //pagenation
    public List<FlightBooking> paginationOfFlightBookings(int pageSize,int pageNo)
    {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<FlightBooking> pages = flightRepo.findAll(pageRequest);
        return pages.toList();
    }
    //sorting + pagination
    public List<FlightBooking> SortAndPagenation(int pageSize,int pageNo,String SortBy)
    {
        Sort sort = Sort.by(SortBy).ascending();
        PageRequest page = PageRequest.of(pageNo, pageSize,sort);
        Page<FlightBooking> pages = flightRepo.findAll(page);
        return pages.toList();
    }
}
