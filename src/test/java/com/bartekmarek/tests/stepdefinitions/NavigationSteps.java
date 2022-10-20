package com.bartekmarek.tests.stepdefinitions;

import com.bartekmarek.cucumber.TestContext;
import com.bartekmarek.page.components.MainPageHeader;
import com.bartekmarek.page.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class NavigationSteps extends BaseSteps {

    public NavigationSteps(TestContext context) {
        super(context);
    }

    @Given("I'm on Brew Dog main page")
    public void goToMainPage() {
        MainPage mainPage = pageGenerator.getInstance(MainPage.class);
        mainPage.goToMainPage();
    }

    @And("I navigate to all beers selection page")
    public void iNavigateToAllBeersSelectionPage() {
        pageGenerator.getInstance(MainPageHeader.class).navigateToAllBeersShopPage();
    }

    @And("I navigate to Bars booking page")
    public void iNavigateToBarsBookingPage() {
        pageGenerator.getInstance(MainPageHeader.class).navigateToBarBookingPage();
    }

    @When("I navigate to my basket")
    public void iNavigateToMyBasket() {
        pageGenerator.getInstance(MainPageHeader.class).navigateToBasket();
    }
}