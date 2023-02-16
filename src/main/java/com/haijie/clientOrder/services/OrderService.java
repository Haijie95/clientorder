package com.haijie.clientOrder.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haijie.clientOrder.models.Orders;
import com.haijie.clientOrder.repositories.OrderRepo;

@Service
public class OrderService {

    @Autowired
    OrderRepo oRepo;

    public void addOrder(Orders order) {
        String commentId = UUID.randomUUID().toString().substring(0, 8);
		order.setOrderId(commentId);
        oRepo.insertOrder(order);
    }
    
}
