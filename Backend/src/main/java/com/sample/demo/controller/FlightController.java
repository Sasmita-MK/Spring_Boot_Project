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
import org.springframework.web.bind.annotation.RequestParam;






@RestController
@RequestMapping("/admin")
public class FlightController {
    @Autowired
    FlightService flightService;

    //Create
    @PostMapping("/insert")
    public FlightBooking insertNewData(@RequestBody FlightBooking InsertThis) {
        return flightService.createFlight(InsertThis);
    }

    //read
    @GetMapping("/getAll")
    public List<FlightBooking> getAllFlightData() {
        return flightService.getFlightBookings();
    }

    //Update
    @PutMapping("/update/{id}")
    public String UpdateTheFlight(@PathVariable int id,@RequestBody FlightBooking fb) {
        boolean done = flightService.updateFlightBooking(id, fb);
        if(done)
        {
            return "Successfully updated";
        }else{
            return "ID Not found Enter the correct ID to be updated";
        }
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public String DeleteThisFlight(@PathVariable int id) {
        boolean done = flightService.deleteFlightBooking(id);
        if(done)
        {
            return "Successfully deleted";
        }else{
            return "ID Not found Enter the correct ID to be deleted";
        }
    }

    // Sort
   @GetMapping("/sort/{field}")
   public List<FlightBooking> sortTheFlight(@PathVariable String field) {
        return flightService.sortFlightBooking(field);
   }

   // Paginate
   @GetMapping("/paginate/{offset}/{pageSize}")
   public List<FlightBooking> paginateTheFlight(@PathVariable int offset, @PathVariable int pageSize) {
        return flightService.paginateFlightBooking(offset, pageSize);
   }  
   
   // PaginateAndSort
   @GetMapping("/paginateandsort/{offset}/{pageSize}/{field}") 
   public List<FlightBooking> paginateAndSortTheFlight(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        return flightService.paginateAndSortFlightBooking(offset, pageSize, field);
   }
}
