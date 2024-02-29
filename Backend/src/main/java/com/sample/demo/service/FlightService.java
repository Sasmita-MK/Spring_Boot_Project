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

    // Create
    public FlightBooking createFlight(FlightBooking flightBooking) {
        return flightRepo.save(flightBooking);
    }

    // Read
    public List<FlightBooking> getFlightBookings() {
        return flightRepo.findAll();
    }

    // Update
    public boolean updateFlightBooking(int id, FlightBooking fb) {
        FlightBooking toBeUpdated = flightRepo.findById(id).orElse(null);
        if (toBeUpdated == null) {
            return false;
        } else {
            flightRepo.save(fb);
            return true;
        }
    }

    // Delete
    public boolean deleteFlightBooking(int id) {
        FlightBooking toBeDeleted = flightRepo.findById(id).orElse(null);
        if (toBeDeleted == null) {
            return false;
        } else {
            flightRepo.delete(toBeDeleted);
            return true;
        }
    }

    // Sorting
    public List<FlightBooking> sortFlightBooking(String field) {
        Sort sort = Sort.by(field).ascending();
        return flightRepo.findAll(sort);
    }

    // Pagination
    public List<FlightBooking> paginateFlightBooking(int offset, int pageSize) {
        PageRequest pageRequest = PageRequest.of(offset, pageSize);
        Page<FlightBooking> page = flightRepo.findAll(pageRequest);
        return page.toList();
    }

    // Pagination and Sorting
    public List<FlightBooking> paginateAndSortFlightBooking(int offset, int pageSize, String field) {
        Sort sort = Sort.by(field).ascending();
        PageRequest pageRequest = PageRequest.of(offset, pageSize, sort);
        Page<FlightBooking> page = flightRepo.findAll(pageRequest);
        return page.toList();
    }
}
