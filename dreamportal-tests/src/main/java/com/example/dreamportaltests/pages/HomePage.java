package com.example.dreamportaltests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;

public class HomePage {
    private WebDriver driver;
    private final By loadingAnimation = By.id("loadingAnimation");
    private final By mainContent = By.id("mainContent");
    private final By myDreamsButton = By.id("dreamButton");

    public HomePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance cannot be null");
        }
        this.driver = driver;
    }

    /**
     * Checks if the loading animation is visible.
     */
    public boolean isLoadingVisible() {
        try {
            return driver.findElement(loadingAnimation).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance cannot be null");
        }
        this.driver = driver;
    }

    public By getLoadingAnimation() {
        return loadingAnimation;
    }

    public By getMyDreamsButton() {
        return myDreamsButton;
    }

    public By getMainContent() {
        return mainContent;
    }

    /**
     * Checks if the main content is visible.
     */
    public boolean isMainContentVisible() {
        try {
            return driver.findElement(mainContent).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the "My Dreams" button is visible.
     */
    public boolean isMyDreamsBtnVisible() {
        try {
            return driver.findElement(myDreamsButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void clickMyDreams() {
        driver.findElement(myDreamsButton).click();
    }
}
