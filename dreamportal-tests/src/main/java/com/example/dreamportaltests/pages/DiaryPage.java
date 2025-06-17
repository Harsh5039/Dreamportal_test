package com.example.dreamportaltests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

public class DiaryPage {
    private final WebDriver driver;

    private final By diaryRows = By.cssSelector("#dreamsDiary tbody tr");

    public DiaryPage(WebDriver driver) {
        this.driver = driver;
    }


    public int getDreamCount() {
        return driver.findElements(diaryRows).size();
    }


    public boolean areDreamTypesValid() {
        List<WebElement> rows = driver.findElements(diaryRows);
        for (WebElement row : rows) {
            List<WebElement> tds = row.findElements(By.tagName("td"));
            if (tds.size() == 3) {
                String type = tds.get(2).getText().trim();
                if (!(type.equals("Good") || type.equals("Bad"))) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean areAllColumnsFilled() {
        List<WebElement> rows = driver.findElements(diaryRows);
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if (cols.size() != 3) return false;
            for (WebElement col : cols) {
                if (col.getText().trim().isEmpty()) return false;
            }
        }
        return true;
    }


    public Set<String> getRecurringDreamNames() {
        List<WebElement> rows = driver.findElements(diaryRows);
        Map<String, Integer> nameCounts = new HashMap<>();
        for (WebElement row : rows) {
            List<WebElement> tds = row.findElements(By.tagName("td"));
            if (tds.size() == 3) {
                String name = tds.get(0).getText().trim();
                nameCounts.put(name, nameCounts.getOrDefault(name, 0) + 1);
            }
        }
        Set<String> recurring = new HashSet<>();
        for (Map.Entry<String, Integer> entry : nameCounts.entrySet()) {
            if (entry.getValue() > 1) {
                recurring.add(entry.getKey());
            }
        }
        return recurring;
    }
}
