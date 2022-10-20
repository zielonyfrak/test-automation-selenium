package com.bartekmarek.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverSupplier {
    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        options.addArguments("--headless"); //TODO parametrize it
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--ignore-certificare-errors");
        options.addArguments("--verbose");
        options.addArguments("--no-sandbox");
        options.addArguments("--whitelisted-ips");
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    };

    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        return new FirefoxDriver(options);
    };

    private static final Supplier<WebDriver> ieDriverSupplier = () -> {
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.introduceFlakinessByIgnoringSecurityDomains();
        options.ignoreZoomSettings();
        options.disableNativeEvents();
        return new InternetExplorerDriver(options);
    };

    static {
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
        driverMap.put(DriverType.IE, ieDriverSupplier);
    }

    private final String driverProperties = System.getProperty("browser");

    WebDriver getDriver() {
        WebDriver driver = selectDriver(driverProperties);
        driver.manage().window().maximize(); //TODO is needed?
        return driver;
    }

    private WebDriver selectDriver(String driverProperties) {
        switch (driverProperties) {
            case "chrome":
                return driverMap.get(DriverType.CHROME).get();
            case "firefox":
                return driverMap.get(DriverType.FIREFOX).get();
            case "ie":
                return driverMap.get(DriverType.IE).get();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + driverProperties);
        }
    }
}