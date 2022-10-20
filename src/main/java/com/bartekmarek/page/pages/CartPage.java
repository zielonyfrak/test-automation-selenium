package com.bartekmarek.page.pages;

import com.bartekmarek.model.BasketItem;
import com.bartekmarek.page.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//tbody[@class='cart item']")
    List<WebElement> cartItems;

    @FindBy(xpath = "//*[@class='grand totals']//*[@class='price']")
    WebElement totalPrice;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<BasketItem> getCartItems() {
        List<BasketItem> basketItems = new ArrayList<>();
        //TODO if not empty
        for (WebElement cartItem : cartItems) {
            BasketItem item = BasketItem.builder()
                    .name(cartItem.findElement(By.xpath(".//*[@class='product-item-name']//a")).getText())
                    .quantity(Integer.parseInt(cartItem.findElement(By.xpath(".//*[@class='input-text qty full-update-cart-item']")).getAttribute("value")))
                    .priceAsString(cartItem.findElement(By.className("price")).getText())
                    .build();
            basketItems.add(item);
        }
        return basketItems;
    }

    public BigDecimal getTotalPrice() {
        return new BigDecimal(getText(totalPrice).replace("£", ""));
    }
}