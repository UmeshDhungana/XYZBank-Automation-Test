package com.xyzbank.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.xyzbank.model.pages.HomePage;

import org.junit.jupiter.api.Test;

public class AddCustomerTest extends BaseTestSuite {

  @Test
  public void verifyAddCustomer() {
    var addCustomerPage = new HomePage(driver)
        .clickBankManagerLogin()
        .clickAddCustomerAtTop()
        .setFirstName("Van")
        .setLastName("Persie")
        .setPostCode("2222")
        .clickAddCustomerToSubmit();
   /*  
    expected customer id is not always be 6 in real case scenario. Initially there are 5 customer so next id is 6 
    */
    assertEquals("Customer added successfully with customer id :6", 
                addCustomerPage.getCustomerAddSuccessAlertMessage());
  }
  
}
