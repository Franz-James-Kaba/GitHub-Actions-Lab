package com.lab.banktest.managerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagerDasboard {
    private final  WebDriver driver;
    private final By addCustomerButton = By.cssSelector("body > div > div > div.ng-scope > div > div.center > button:nth-child(1)");
    private final By openAccountButton = By.cssSelector("body > div > div > div.ng-scope > div > div.center > button:nth-child(2)");
    private final By customersButton = By.cssSelector("body > div > div > div.ng-scope > div > div.center > button:nth-child(3)");




    public ManagerDasboard(WebDriver driver) {
        this.driver = driver;
    }


    public AddCustomer clickAddCustomerButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerButton));
        driver.findElement(addCustomerButton).click();
        return new AddCustomer(driver);
    }

    public OpenAccount clickOpenAccountButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(openAccountButton));
        driver.findElement(openAccountButton).click();
        return new OpenAccount(driver);
    }

    public CustomerManagement clickCustomerButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(customersButton));
        driver.findElement(customersButton).click();
        return new CustomerManagement(driver);
    }





}
