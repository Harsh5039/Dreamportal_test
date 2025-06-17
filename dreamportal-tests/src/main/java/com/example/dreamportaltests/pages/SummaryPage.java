package com.example.dreamportaltests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryPage {
    private final WebDriver driver;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }


    public int getGoodDreamsCount() {
        WebElement element = driver.findElement(By.xpath("//tr[td[normalize-space()='Good Dreams']]/td[2]"));
        return Integer.parseInt(element.getText().trim());
    }


    public int getBadDreamsCount() {
        WebElement element = driver.findElement(By.xpath("//tr[td[normalize-space()='Bad Dreams']]/td[2]"));
        return Integer.parseInt(element.getText().trim());
    }
}
