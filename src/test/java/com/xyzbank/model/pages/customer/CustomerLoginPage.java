package com.xyzbank.model.pages.customer;

import com.xyzbank.model.pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerLoginPage extends BasePage {

  public CustomerLoginPage(WebDriver driver) {
    super(driver);
  }

  public CustomerLoginPage selectCustomerName() {
    Select dropdown = new Select(driver.findElement(By.id("userSelect")));
    dropdown.selectByValue("1");
    // dropdown.selectByVisibleText("Hermoine Granger");
    return this;
  }

  public AccountPage clickLoginButton() {
    driver.findElement(By.cssSelector("button[type='submit']")).click();
    return new AccountPage(driver);
  }

  
}
