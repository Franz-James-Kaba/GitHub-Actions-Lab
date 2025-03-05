package com.lab.customertests;

import com.lab.base.Setup;
import org.junit.jupiter.api.Test;

public class WithdrawTests extends Setup {
    String withdrawalAmount = "7000";
    String depositAmount = "90000";

    @Test
    public void testSuccessfulWithdrawal() {
        //Login customer
        customerManagement.goHome();
        homePage.clickLoginCustomerButton();
        customerDashboard.selectCustomerName("Harry Potter");
        customerDashboard.clickLoginButton();

        //Navigate to the withdraw page from the customer account dashboard
        customerAccountDashboard.clickwithdrawButton();
        withdrawPage.inputAmount(depositAmount);
        withdrawPage.clickWithdrawButton();
    }

    @Test
    public void testWithdrawalUpdate() {
        // Step 1: Login and navigate to deposit page
        customerManagement.goHome();
        homePage.clickLoginCustomerButton();
        customerDashboard.selectCustomerName("Harry Potter");
        customerDashboard.clickLoginButton();


        // Deposit Money
        customerAccountDashboard.clickDepositButton();
        depositPage.enterAmount(depositAmount);
        depositPage.clickDeposit();

        // Step 3: Withdraw money
        customerManagement.goHome();
        homePage.clickLoginCustomerButton();
        customerDashboard.selectCustomerName("Harry Potter");
        customerDashboard.clickLoginButton();
        customerAccountDashboard.clickwithdrawButton();
        withdrawPage.inputAmount(withdrawalAmount);
        withdrawPage.clickWithdrawButton();

    }
}