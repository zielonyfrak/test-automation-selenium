package com.bartekmarek.page.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BasePage extends PageGenerator {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return super.driver.getTitle();
    }

    public void click(WebElement element) {
        waitUntil().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        //wait for page to reload??
    }

    public FluentWait<WebDriver> waitUntil(Duration timeout, Duration polling) {
        return new FluentWait<>(super.driver)
                .withTimeout(timeout)
                .pollingEvery(polling)
                .ignoring(NoSuchElementException.class);
    }

    public FluentWait<WebDriver> waitUntil() {
        return this.waitUntil(Duration.ofSeconds(10), Duration.ofSeconds(1));
    }

    protected boolean isVisible(WebElement element) {
        try {
            waitUntil(Duration.ofSeconds(5), Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isPresent(By elementLocator) {
        try {
            waitUntil(Duration.ofSeconds(10), Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated(elementLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isVisible(By elementLocator) {
        return driver.findElements(elementLocator).size() != 0;
    }
}
