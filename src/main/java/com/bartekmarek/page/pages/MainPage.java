package com.bartekmarek.page.pages;

import com.bartekmarek.page.base.BasePage;
import com.bartekmarek.properties.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'We use cookies')]")
    WebElement cookiesMessage;

    @FindBy(xpath = "//button[@data-testid='consent-manager-okay-button']")
    WebElement cookiesOkeyButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage goToMainPage() {
        String baseUrl = PropertiesManager.getBaseUrl();
        driver.get(baseUrl);
        if (isCookieMessageDisplayed()){
            click(cookiesOkeyButton);
        }
        return this;
    }

    public boolean isCookieMessageDisplayed(){
        return isVisible(cookiesMessage);
    }
}