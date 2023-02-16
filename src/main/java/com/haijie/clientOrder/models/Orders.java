package com.haijie.clientOrder.models;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private String name;
    private String email;
    private LocalDate deliveryDate;
    private List<LineItems> lineItems;
    private String orderId;


    public static Orders create(String json) throws IOException{
        Orders ord = new Orders();
        List<LineItems> result = new LinkedList<LineItems>();
        try(InputStream is = new ByteArrayInputStream(json.getBytes())){
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
            ord.setName(o.getString("name"));
            ord.setEmail(o.getString("email"));
            ord.setDeliveryDate(LocalDate.parse(o.getString("deliveryDate")));
            JsonArray itemsList = o.getJsonArray("lineItems");
            for (int i=0;i<itemsList.size();i++){
                JsonObject jo = itemsList.getJsonObject(i);
                LineItems li = LineItems.create(jo);
                result.add(li);
            }    
        }
        ord.setLineItems(result);
        return ord;
    }


    public Document toDocument() {
        Document doc = new Document();
        doc.put("orderId", getOrderId());
        doc.put("name", getName());
        doc.put("email", getEmail());
        doc.put("deliveryDate", getDeliveryDate());
        doc.put("lineItems", getLineItems());

        return doc;
    }
}


