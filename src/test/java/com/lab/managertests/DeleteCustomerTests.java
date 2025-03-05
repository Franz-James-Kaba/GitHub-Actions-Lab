package com.lab.managertests;

import com.lab.base.Setup;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeleteCustomerTests extends Setup {
    private static String firstName = "Harry";
    private static String lastName = "Potter";
    @Test
    public void testSuccessfulDeleteCustomer(){
        homePage.clickManagerLogin();
        managerDasboard.clickCustomerButton();
        customerManagement.deleteCustomer(firstName,lastName);
    }
    @Test
    public void testVerifyDelete(){
        customerManagement.goHome();
        homePage.clickManagerLogin();
        managerDasboard.clickOpenAccountButton();
        // Verify that trying to select an invalid customer name throws an exception
        assertThrows(NoSuchElementException.class, () -> {
            openAccount.selectCustomerDropDwn(firstName+lastName);
            openAccount.setCurrencyDropDown("Dollar");
            openAccount.clickProcessButton();
        });
    }
}
