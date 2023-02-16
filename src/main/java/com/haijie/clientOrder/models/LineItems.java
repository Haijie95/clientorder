package com.haijie.clientOrder.models;

import jakarta.json.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineItems {
    private String item;
    private int quantity;

    public static LineItems create(JsonObject o){
        LineItems li = new LineItems();
        li.setItem(o.getString("item"));
        li.setQuantity(o.getInt("quantity"));
        return li;
    }
}
