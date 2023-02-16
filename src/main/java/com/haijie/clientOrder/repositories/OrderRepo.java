package com.haijie.clientOrder.repositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.haijie.clientOrder.models.Orders;

@Repository
public class OrderRepo {

    @Autowired
    MongoTemplate template;

    public void insertOrder(Orders order) {
        Document doc = order.toDocument();
        template.insert(doc,"orders");
    }
    
}
