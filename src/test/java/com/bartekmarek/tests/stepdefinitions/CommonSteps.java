package com.bartekmarek.tests.stepdefinitions;

import com.bartekmarek.cucumber.TestContext;
import io.cucumber.java.en.Then;

public class CommonSteps extends BaseSteps {
    public CommonSteps(TestContext context) {
        super(context);
    }

    @Then("Page title should be like {string}")
    public void pageTitleShouldBeLike(String expectedPageTitle) {
        testPageTitle(expectedPageTitle);
    }
}
