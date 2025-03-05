package com.lab.customertests;

import com.lab.base.Setup;
import org.junit.jupiter.api.Test;

public class CustomerLoginTests extends Setup {

    @Test
    public void testSuccessfulCustomerLogin(){
        homePage.clickLoginCustomerButton();
        customerDashboard.selectCustomerName("Harry Potter");
    }
}
