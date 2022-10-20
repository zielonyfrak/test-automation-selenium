package com.bartekmarek.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data  //TODO remove or change to Value
@Builder
public class BasketItem {
    private int quantity;
    private String name;
    private String priceAsString;

    public BigDecimal getPrice() {
        return new BigDecimal(priceAsString.replace("£", ""));
    }

    public BigDecimal getTotalItemPrice() {
        BigDecimal qty = new BigDecimal(quantity);
        return getPrice().multiply(qty);
    }
}
