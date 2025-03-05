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
import org.openqa.selenium.chrome.ChromeOptions;

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
    public static void setUp() {
        // Configure ChromeOptions for better compatibility in CI/CD environments
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode (no GUI)
        options.addArguments("--disable-gpu"); // Disable GPU acceleration (required for headless mode)
        options.addArguments("--no-sandbox"); // Bypass OS security model (required for CI/CD)
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        options.addArguments("--remote-allow-origins=*"); // Allow remote origins (required for newer ChromeDriver versions)
        options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis()); // Unique user data directory

        // Initialize ChromeDriver with the configured options
        driver = new ChromeDriver(options);

        // Navigate to the application URL
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        // Initialize page objects
        homePage = new HomePage(driver);
        managerDasboard = new ManagerDasboard(driver);
        addCustomer = new AddCustomer(driver);
        openAccount = new OpenAccount(driver);
        customerDashboard = new CustomerDashboard(driver);
        customerManagement = new CustomerManagement(driver);
        depositPage = new DepositPage(driver);
        customerAccountDashboard = new CustomerAccountDashboard(driver);
        withdrawPage = new WithdrawPage(driver);
    }

    @AfterAll
    public static void tearDown() {
        // Quit the driver to clean up resources
        if (driver != null) {
            driver.quit();
        }
    }
}