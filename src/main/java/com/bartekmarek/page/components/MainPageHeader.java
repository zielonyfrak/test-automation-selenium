package com.bartekmarek.page.components;

import com.bartekmarek.page.base.BasePage;
import com.bartekmarek.page.pages.AllBeersPage;
import com.bartekmarek.page.pages.BarBookingPage;
import com.bartekmarek.page.pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageHeader extends BasePage {

    public MainPageHeader(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-testid='nav-menu' and text()='Shop']")
    private WebElement shopMenu;

    @FindBy(xpath = "//*[@data-testid='nav-menu' and text()='Book']")
    private WebElement bookMenu;

    @FindBy(xpath = "//*[@data-testid='nav-menu-subitem']//span[text()=' Beer']")
    private WebElement beerMenuItem;

    @FindBy(xpath = "//*[@data-testid='nav-menu-subitem']//span[text()='Bars']")
    private WebElement barsMenuItem;

    @FindBy(xpath = "//*[@data-testid='nav-menu-subitem']//span[text()='Shop All']")
    private WebElement shopAllBeerMenuSubItem; 

    @FindBy(xpath = "//*[@data-testid='cart-button']")
    private WebElement basketButton;

    public AllBeersPage navigateToAllBeersShopPage(){
        click(shopMenu);
        click(beerMenuItem);
        click(shopAllBeerMenuSubItem);
        return getInstance(AllBeersPage.class);
    }

    public BarBookingPage navigateToBarBookingPage(){
        click(bookMenu);
        click(barsMenuItem);
        return getInstance(BarBookingPage.class);
    }

    public CartPage navigateToBasket(){
        click(basketButton);
        return getInstance(CartPage.class);
    }
}
