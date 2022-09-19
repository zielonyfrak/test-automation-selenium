package com.bartekmarek.tests.stepdefinitions;


import com.bartekmarek.driver.PageManager;
import com.bartekmarek.page.base.PageGenerator;
import com.bartekmarek.page.components.MainPageHeader;
import com.bartekmarek.page.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class BaseSteps {

    private final PageGenerator pageGenerator = PageManager.getInstance().getPageGenerator();

    @Given("I'm on Brew Dog main page")
    public void goToMainPage() {
        MainPage mainPage = pageGenerator.getInstance(MainPage.class);
        mainPage.goToMainPage();
    }

    @And("I navigate to all beers selection page")
    public void iNavigateToAllBeersSelectionPage() {
        pageGenerator.getInstance(MainPageHeader.class).navigateToAllBeersShopPage();
    }
}