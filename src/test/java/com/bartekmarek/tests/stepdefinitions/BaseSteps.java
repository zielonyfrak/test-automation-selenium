package com.bartekmarek.tests.stepdefinitions;

import com.bartekmarek.cucumber.TestContext;
import com.bartekmarek.driver.PageManager;
import com.bartekmarek.page.base.BasePage;
import com.bartekmarek.page.base.PageGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseSteps {

    final PageGenerator pageGenerator;
    TestContext context;

    public BaseSteps(TestContext context) {
        this.context = context;
        pageGenerator = PageManager.getInstance().getPageGenerator();
    }

    protected void testPageTitle(String expectedPageTitle) {
        assertThat(pageGenerator.getInstance(BasePage.class).isPageTileLike(expectedPageTitle))
                .as("Actual page title doesn't match to: " + expectedPageTitle)
                .isTrue();
    }
}