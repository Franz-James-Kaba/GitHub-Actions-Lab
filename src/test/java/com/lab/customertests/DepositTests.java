package com.lab.customertests;

import com.lab.base.Setup;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositTests extends Setup {

    String depositAmount = "9000";
    @Test
    public void testDepositSuccess(){
        homePage.clickLoginCustomerButton();
        customerDashboard.selectCustomerName("Harry Potter");
        customerDashboard.clickLoginButton();
        customerAccountDashboard.clickDepositButton();
        depositPage.enterAmount(depositAmount);
        depositPage.clickDeposit();
    }
    @Test
    public void testDepositfail(){
        depositPage.enterAmount("-9000");
        depositPage.clickDeposit();
    }
    @Test
    public void testDepositUpdate() {
        // Step 1: Login and navigate to deposit page
        customerManagement.goHome();
        homePage.clickLoginCustomerButton();
        customerDashboard.selectCustomerName("Harry Potter");
        customerDashboard.clickLoginButton();
        customerAccountDashboard.clickDepositButton();

        // Step 2: Get initial balance
        String initialBalance = depositPage.getBalanceAmount();

        // Step 3: Deposit money
        depositPage.enterAmount(depositAmount);
        depositPage.clickDeposit();

        // Step 4: Get updated balance
        String updatedBalance = depositPage.getBalanceAmount();

        // Step 5: Assert balance is updated correctly
        int expectedBalance = Integer.parseInt(initialBalance) + Integer.parseInt(depositAmount);
        assertEquals(expectedBalance, Integer.parseInt(updatedBalance),
                "Balance should increase by " + depositAmount);
    }

}
