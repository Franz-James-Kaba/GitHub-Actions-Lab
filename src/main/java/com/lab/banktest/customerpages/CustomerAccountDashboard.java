package com.lab.banktest.customerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerAccountDashboard {


    public CustomerAccountDashboard(WebDriver driver) {
        this.driver = driver;
    }

    private static WebDriver driver;

    private final static By transactionsButton =  By.cssSelector("body > div > div > div.ng-scope > div > div:nth-child(5) > button:nth-child(1)");
    private final static By depositButton =  By.cssSelector("body > div > div > div.ng-scope > div > div:nth-child(5) > button:nth-child(2)");
    private final static By withdrawalButton =  By.cssSelector("body > div > div > div.ng-scope > div > div:nth-child(5) > button:nth-child(3)");

    public TransactionsPage clickTransactionsButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(transactionsButton));
        driver.findElement(transactionsButton).click();
        return new TransactionsPage(driver);
    }
    public DepositPage clickDepositButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(depositButton));
        driver.findElement(depositButton).click();
        return new DepositPage(driver);
    }

    public WithdrawPage clickwithdrawButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(withdrawalButton));
        driver.findElement(withdrawalButton).click();
        return new WithdrawPage(driver);
    }





}
