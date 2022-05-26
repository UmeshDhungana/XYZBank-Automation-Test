package com.xyzbank.model.pages.customer;

import com.xyzbank.model.pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

  public AccountPage(WebDriver driver) {
    super(driver);
  }

  public String getWelcomeMessage() {
    return driver.findElement(By.cssSelector("strong span.fontBig")).getText();
  }

  public String getAccountBalance() {
    var accountBalance = driver.findElements(By.cssSelector("div.center"))
                               .stream()
                               .filter(s -> s.getText().startsWith("Account"))
                               .findFirst()
                               .get()
                               .getText();
    System.out.println(accountBalance);

    String[] splitEntireString = accountBalance.split(" , ");
    String balanceString = splitEntireString[1]; 

    System.out.println(balanceString);

    String[] splitBalanceString = balanceString.split("Balance : ");
    String balance_value = splitBalanceString[1];
                               
    System.out.println(balance_value);
    return balance_value;
  }

  public AccountPage clickDepositOnTop() {
    //Did not work with class name so had to go with CSS Selector
    //Still better approach to use findElementByTest if there are other cssSelector with same name
    findElementByText(By.cssSelector("button.btn-lg"), "Deposit").click();;
    return this;
  }

  public AccountPage setDepositAmount(String amount) {
    driver.findElement(By.cssSelector("input[type='number']")).sendKeys(amount);
    return this;
  }

  public AccountPage clickDepositToSubmit() {
    findElementByText(By.className("btn-default"), "Deposit").click();
    return this;
  }

  public String verifyBalanceUpdatedOnDeposit() {
    // int currentBalance = Integer.parseInt(getAccountBalance());
    // int depositedAmount = Integer.parseInt(amount);
    // System.out.println(currentBalance);
    // int updatedBalacne = currentBalance+depositedAmount;
    // System.out.println(updatedBalacne + " " + getAccountBalance());
    return getAccountBalance();
  }

  public String verifySuccessfulDepositMessage() {
    return driver.findElement(By.className("error")).getText();
  }
  
}
