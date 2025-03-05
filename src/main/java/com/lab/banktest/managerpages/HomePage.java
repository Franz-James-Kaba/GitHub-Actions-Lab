package com.lab.banktest.managerpages;

import com.lab.banktest.customerpages.CustomerDashboard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
final
    private  By loginManagerButton = By.cssSelector("body > div > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(3) > button");
    private final By loginCustomerButton = By.cssSelector("body > div > div > div.ng-scope > div > div.borderM.box.padT20 > div:nth-child(1) > button");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ManagerDasboard clickManagerLogin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(loginManagerButton));
        driver.findElement(loginManagerButton).click();
        return new ManagerDasboard(driver);
    }

    public CustomerDashboard clickLoginCustomerButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginCustomerButton));
        driver.findElement(loginCustomerButton).click();
        return new CustomerDashboard(driver);
    }
}
