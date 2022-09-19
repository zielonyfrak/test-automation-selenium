package com.bartekmarek.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/bartekmarek/tests/features"},
        glue = {"src/test/java/com/bartekmarek/tests/stepdefinitions"}
)
public class BrewDogTest {
}
