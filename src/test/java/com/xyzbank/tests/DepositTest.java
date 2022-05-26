package com.xyzbank.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.xyzbank.model.pages.HomePage;

import org.junit.jupiter.api.Test;

public class DepositTest extends BaseTestSuite {

  @Test
  public void verifySuccessfulLogin() {
    var accountPage = new HomePage(driver)
        .clickCustomerLogin()
        .selectCustomerName()
        .clickLoginButton();

    //could not get entire text of within <strong> without using xpath.
    //so checking that name is displayed in welcome message
    assertEquals("Hermoine Granger", accountPage.getWelcomeMessage());
  }

  @Test
  public void verifySuccessfulDeposit() {
    var depositPage = new HomePage(driver)
        .clickCustomerLogin()
        .selectCustomerName()
        .clickLoginButton()
        .clickDepositOnTop()
        .setDepositAmount("1000")
        .clickDepositToSubmit();
    
    //initial balance is 5096
    assertEquals("6096", depositPage.verifyBalanceUpdatedOnDeposit());
    assertEquals("Deposit Successful", depositPage.verifySuccessfulDepositMessage());
  }
}
