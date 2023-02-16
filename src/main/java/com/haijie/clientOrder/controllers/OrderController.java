package com.haijie.clientOrder.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haijie.clientOrder.models.Orders;
import com.haijie.clientOrder.services.OrderService;

@RestController
@RequestMapping("")
public class OrderController {
    
    @Autowired
    OrderService oSvc;

    @PostMapping("/api/order")
    public ResponseEntity<Orders> saveOrder(@RequestBody String json) throws IOException{
        Orders order = Orders.create(json);
        oSvc.addOrder(order);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }
}
