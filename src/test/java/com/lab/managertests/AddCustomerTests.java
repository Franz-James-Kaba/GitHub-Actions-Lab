package com.lab.managertests;


import com.lab.base.Setup;
import org.junit.jupiter.api.Test;

public class AddCustomerTests extends Setup {

    @Test
    public void testManagerLogin() {
        homePage.clickManagerLogin();
    }

    @Test
    public void testSuccessfulAddCustomerCase1(){
        homePage.clickManagerLogin();
        managerDasboard.clickAddCustomerButton();
        addCustomer.setFirstNameField("Titan");
        addCustomer.setLastNameField("Killer");
        addCustomer.setPostalCodeField("59264370");
        addCustomer.clickSubmitButton();
    }

    @Test
    public void testFailAddCustomerCase2(){
        addCustomer.setFirstNameField("Joker123");
        addCustomer.setLastNameField("sga^gst");
        addCustomer.setPostalCodeField("0729354");
        addCustomer.clickSubmitButton();
    }

    @Test
    public void testFailAddCustomerCase3(){
        addCustomer.setFirstNameField("Joker123");
        addCustomer.setLastNameField("sga4543");
        addCustomer.setPostalCodeField("0729354");
        addCustomer.clickSubmitButton();
    }
    @Test
    public void testFailAddCustomerCase4(){
        addCustomer.setFirstNameField("$^$^#");
        addCustomer.setLastNameField("*&%$");
        addCustomer.setPostalCodeField("0729354");
        addCustomer.clickSubmitButton();
    }
    @Test
    public void testFailAddCustomerCase5(){
        addCustomer.setFirstNameField("Titan");
        addCustomer.setLastNameField("Killer");
        addCustomer.setPostalCodeField("5926437ABC0");
        addCustomer.clickSubmitButton();
    }


}
