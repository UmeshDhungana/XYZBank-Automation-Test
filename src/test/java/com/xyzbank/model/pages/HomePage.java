package com.xyzbank.model.pages;

import com.xyzbank.model.pages.customer.CustomerLoginPage;
import com.xyzbank.model.pages.manager.BankManagerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public BankManagerPage clickBankManagerLogin() {
    driver.findElement(By.xpath(".//button[contains(.,'Manager')]")).click();
    return new BankManagerPage(driver);
  }

  public CustomerLoginPage clickCustomerLogin() {
    findElementByText(By.className("center"), "Customer Login").click();
    // driver.findElement(By.xpath(".//button[contains(.,'Customer')]")).click();
    return new CustomerLoginPage(driver);
  }
  
}
