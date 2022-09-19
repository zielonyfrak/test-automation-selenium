package com.bartekmarek.page.components;

import com.bartekmarek.page.base.BasePage;
import com.bartekmarek.page.pages.AllBeersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageHeader extends BasePage {

    public MainPageHeader(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-testid='nav-menu' and text()='Shop']")
    private WebElement shopMenu;

    @FindBy(xpath = "//*[@data-testid='nav-menu-item']//span[text()=' Beer']")
    private WebElement beerMenuItem;

    @FindBy(xpath = "//*[@data-testid='nav-menu-subitem']//span[text()='Shop All']")
    private WebElement shopAllBeerMenuSubItem;

    public AllBeersPage navigateToAllBeersShopPage(){
        click(shopMenu);
        click(beerMenuItem);
        click(shopAllBeerMenuSubItem);
        return getInstance(AllBeersPage.class);
    }
}
