package com.bartekmarek.tests.stepdefinitions;

import com.bartekmarek.cucumber.TestContext;
import com.bartekmarek.driver.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.ArrayList;

public class TestHooks {

    private TestContext context;

    public TestHooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp() {
        PageManager.getInstance().initialisePageGenerator();
        context.setBasket(new ArrayList<>());
    }

    @After
    public void teardown() {
        PageManager.getInstance().closeDriver();
        PageManager.cleanUp();
    }
}