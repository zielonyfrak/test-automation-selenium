package com.bartekmarek.page.pages;

import com.bartekmarek.model.BasketItem;
import com.bartekmarek.page.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllBeersPage extends BasePage {

    @FindBy(xpath = "//*[@class='rounded-xl p-px flex flex-col h-full']")
    private List<WebElement> productCards;

    public AllBeersPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProductCardByIndex(int index) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Number of beers: " + productCards.size());

        for (WebElement card : productCards) {
            String cardTitle = card.findElement(By.xpath(".//*[@data-testid='product-card-title']")).getText();
            System.out.println("Card title: " + cardTitle);
        }

        return productCards.get(index); //TODO size check
    }

    public BasketItem addToBasketFirstProduct(int numberOfPcs) {
        WebElement productCard = getProductCardByIndex(2);
        productCard.findElement(By.xpath(".//button[@data-testid='add-to-bag-button']")).click();
        numberOfPcs--;
        while (isPresent(By.xpath(".//button[@data-testid='increase-quantity-button']")) && numberOfPcs > 0) {
            click(productCard.findElement(By.xpath(".//button[@data-testid='increase-quantity-button']")));
            numberOfPcs--;
        }

        BasketItem basketItem = BasketItem.builder().build();

        if (isPresent(By.xpath(".//*[@data-testid='product-count']"))) {
            basketItem = BasketItem.builder()
                    .name(productCard.findElement(By.xpath(".//*[@data-testid='product-card-title']")).getText())
                    .quantity(Integer.parseInt(productCard.findElement(By.xpath(".//*[@data-testid='product-count']")).getText()))
                    .price(productCard.findElement(By.xpath(".//*[@data-testid='product-price']")).getText())
                    .build();

            System.out.println("Basket item: " + basketItem);
        }
        return basketItem;
    }
}
