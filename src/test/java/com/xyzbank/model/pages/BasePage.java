package com.xyzbank.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage clickHomeMenu() {
      driver.findElement(By.className(".home")).click();
      return new HomePage(driver);
  }

    protected WebElement findElementByText(By selector, String text) {
      return driver.findElements(selector)
            .stream()
            .filter(e -> e.getText().equals(text))
            .findFirst()
            .get();
    }
}
