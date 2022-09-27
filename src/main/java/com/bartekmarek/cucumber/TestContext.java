package com.bartekmarek.cucumber;

import com.bartekmarek.model.BasketItem;
import lombok.Data;

import java.util.List;

@Data
public class TestContext {
    List<BasketItem> basket;
}
