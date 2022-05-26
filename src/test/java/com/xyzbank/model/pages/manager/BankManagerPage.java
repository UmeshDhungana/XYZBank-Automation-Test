package com.xyzbank.model.pages.manager;

import com.xyzbank.model.pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankManagerPage extends BasePage{

  public BankManagerPage(WebDriver driver) {
    super(driver);
  }
  
  public AddCustomerPage clickAddCustomerAtTop() {
    // findElementByText(By.cssSelector("button.btn-lg"), "Add Customer").click();
    // driver.findElement(By.cssSelector("button[ng-class='btnClass1']")).click();
    driver.findElement(By.xpath(".//button[contains(.,'Add')]")).click();
    return new AddCustomerPage(driver);
  }
}
