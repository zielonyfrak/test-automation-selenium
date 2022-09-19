package com.bartekmarek.tests.stepdefinitions;

import com.bartekmarek.driver.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestHooks {

    @Before
    public void setUp() {
        PageManager.getInstance().initialisePageGenerator();
    }

    @After
    public void teardown() {
        PageManager.getInstance().closeDriver();
        PageManager.cleanUp();
    }
}