package com.lab.base;

import com.lab.banktest.customerpages.CustomerAccountDashboard;
import com.lab.banktest.customerpages.CustomerDashboard;
import com.lab.banktest.customerpages.DepositPage;
import com.lab.banktest.customerpages.WithdrawPage;
import com.lab.banktest.managerpages.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static ManagerDasboard managerDasboard;
    protected static AddCustomer addCustomer;
    protected static OpenAccount openAccount;
    protected static CustomerDashboard customerDashboard;
    protected static CustomerManagement customerManagement;
    protected static DepositPage depositPage;
    protected static CustomerAccountDashboard customerAccountDashboard;
    protected static WithdrawPage withdrawPage;


    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        homePage = new HomePage(driver);
        managerDasboard =new ManagerDasboard(driver);
        addCustomer = new AddCustomer(driver);
        openAccount =new OpenAccount(driver);
        customerDashboard = new CustomerDashboard(driver);
        customerManagement = new CustomerManagement(driver);
        depositPage =new DepositPage(driver);
        customerAccountDashboard = new CustomerAccountDashboard(driver);
        withdrawPage = new WithdrawPage(driver);
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
