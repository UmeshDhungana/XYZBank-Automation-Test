package com.xyzbank.model.pages.manager;

import com.xyzbank.model.pages.BasePage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage extends BasePage{

  public AddCustomerPage(WebDriver driver) {
    super(driver);
  }

  public AddCustomerPage setFirstName(String firstname) {
    driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys(firstname);   
    // *[ contains (text(), ‘First Name’ )  
    return this;
  }

  public AddCustomerPage setLastName(String lastname) {
    driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys(lastname);    
    return this;
  }

  public AddCustomerPage setPostCode(String postcode) { 
    driver.findElement(By.cssSelector("input[placeholder='Post Code']")).sendKeys(postcode);    
    return this;
  }

  public AddCustomerPage clickAddCustomerToSubmit() {
    driver.findElement(By.cssSelector("button[type='submit']")).click();    

    return this;
  }
  
  public String getCustomerAddSuccessAlertMessage() {
    Alert alert = driver.switchTo().alert();
    String alertMessage = alert.getText();
    alert.accept();
    // System.out.println(alertMessage);
    return alertMessage;
  }
  
}
