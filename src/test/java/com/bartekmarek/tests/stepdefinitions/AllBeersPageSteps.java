package com.bartekmarek.tests.stepdefinitions;

import com.bartekmarek.cucumber.TestContext;
import com.bartekmarek.driver.PageManager;
import com.bartekmarek.model.BasketItem;
import com.bartekmarek.page.base.PageGenerator;
import com.bartekmarek.page.pages.AllBeersPage;
import io.cucumber.java.en.And;

public class AllBeersPageSteps {


    private final PageGenerator pageGenerator = PageManager.getInstance().getPageGenerator();
    private AllBeersPage allBeersPage = pageGenerator.getInstance(AllBeersPage.class);
    private TestContext context;

    public AllBeersPageSteps(TestContext context) {
        this.context = context;
    }

    @And("I add to basket {int} pcs of first beer from the page")
    public void addToBasketPcsOfFirstBeer(int numberOfPcs) {
        BasketItem item = allBeersPage.addToBasketFirstProduct(numberOfPcs);
        context.getBasket().add(item);

        System.out.println("Baskettt: " + context.getBasket());
    }
}
