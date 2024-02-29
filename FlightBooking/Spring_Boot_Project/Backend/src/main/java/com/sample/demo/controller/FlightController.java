package com.sample.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.model.FlightBooking;
import com.sample.demo.service.FlightService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    FlightService flightService;
    //Create
    @PostMapping("/insert")
    public FlightBooking insertNewData(@RequestBody FlightBooking InsertThis)
    {
        return flightService.createFlight(InsertThis);
    }
    //read
    @GetMapping("/getAll")
    public List<FlightBooking> getAllFlightData()
    {
        return flightService.getFlightBookings();
    }
    //Update
    @PutMapping("/update/{id}")
    public String UpdateTheFlight(@PathVariable int id,@RequestBody FlightBooking fb)
    {
        boolean done = flightService.updateFlightBooking(id, fb);
        if(done)
        {
            return "Updated";
        }
        else
        {
            return "ID Not found Enter the correct ID to be updated";
        }
    }
    //Delete
    @DeleteMapping("/delete/{id}")
    public String DeleteThisFlight(@PathVariable int id)
    {
        boolean done = flightService.deleteFlightBooking(id);
        if(done)
        {
            return "Successfully deleted";
        }else{
            return "ID Not found Enter the correct ID to be deleted";
        }
    }
    //Sort
    @GetMapping("/display/{name}")
    public List<FlightBooking> getByFlightNameSorted(@PathVariable("name") String name)
    {
        List<FlightBooking> flightList = flightService.sortByFlightBookingName(name);
        return flightList;
    }
    //pagination
    @GetMapping("/display/{pageSize}/{pageNumber}")
    public List<FlightBooking> getPagination(@PathVariable("pageSize") int pageSize,@PathVariable("pageNumber") int pageNumber)
    {
        List<FlightBooking> flightList = flightService.paginationOfFlightBookings(pageSize, pageNumber);
        return flightList;
    }
    //pagination + sorting
    @GetMapping("/display/{pageSize}/{pageNumber}/{field}")
    public List<FlightBooking> getPaginationandSort(@PathVariable("pageSize") int pageSize,@PathVariable("pageNumber") int pageNumber,@PathVariable("field") String field)
    {
        List<FlightBooking> flightList = flightService.SortAndPagenation(pageSize, pageNumber, field);
        return flightList;
    } 
}
