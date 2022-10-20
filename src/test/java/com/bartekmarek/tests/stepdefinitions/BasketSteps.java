package com.bartekmarek.tests.stepdefinitions;

import com.bartekmarek.cucumber.TestContext;
import com.bartekmarek.model.BasketItem;
import com.bartekmarek.page.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;


public class BasketSteps extends BaseSteps {

    CartPage cartPage;

    public BasketSteps(TestContext context) {
        super(context);
        cartPage = pageGenerator.getInstance(CartPage.class);
    }

    @Then("Ordered beers should be in my basket")
    public void orderedItemsShouldBeInMyCart() {
        assertThat(cartPage.getCartItems())
                .hasSameSizeAs(context.getBasket())
                .hasSameElementsAs(context.getBasket());
    }

    @And("Total price should match what I ordered")
    public void totalPriceShouldMatchWhatIOrdered() {
        BigDecimal totalCartPrice = context.getBasket()
                .stream()
                .map(BasketItem::getTotalItemPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        assertThat(cartPage.getTotalPrice()).as("Total price").isEqualTo(totalCartPrice);
    }
}
