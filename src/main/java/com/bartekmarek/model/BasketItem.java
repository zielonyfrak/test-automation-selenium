package com.bartekmarek.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketItem {
    private int quantity;
    private String name;
    private String price;
}
