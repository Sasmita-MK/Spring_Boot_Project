package com.sample.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.model.OrderRequest;
import com.sample.demo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    //Create
    @PostMapping("/insert")
    public OrderRequest insertNewData(@RequestBody OrderRequest InsertThis)
    {
        return orderService.insertOrder(InsertThis);
    }
    //read
    @GetMapping("/getAll")
    public List<OrderRequest> getAllOrderData()
    {
        return orderService.getOrder();
    }
    //Update
    @PutMapping("/update/{id}")
    public String UpdateTheOrder(@PathVariable int id,@RequestBody OrderRequest u)
    {
        boolean done = orderService.updateOrder(id, u);
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
    public String DeleteThisOrder(@PathVariable int id)
    {
        boolean done = orderService.deleteOrder(id);
        if(done)
        {
            return "Successfully deleted";
        }else{
            return "ID Not found Enter the correct ID to be deleted";
        }
    }
}
