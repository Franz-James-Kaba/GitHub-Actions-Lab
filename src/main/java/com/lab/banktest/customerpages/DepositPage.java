package com.lab.banktest.customerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DepositPage {
 private  WebDriver driver;

    public DepositPage(WebDriver driver) {
        this.driver = driver;
    }
    private static By amountField = By.cssSelector("body > div > div > div.ng-scope > div > div.container-fluid.mainBox.ng-scope > div > form > div > input");
    private static By depositButton = By.cssSelector("body > div > div > div.ng-scope > div > div.container-fluid.mainBox.ng-scope > div > form > button");
    private static By balanceValue = By.xpath("//div[contains(@class, 'center')]//strong[2]");

    public void enterAmount(String amount){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));
        driver.findElement(amountField).sendKeys(amount);
    }
    public void clickDeposit() {
        driver.findElement(depositButton).click();
    }
    public String getBalanceAmount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(balanceValue));
        String actualAmount = driver.findElement(balanceValue).getText().trim();
        return actualAmount;
    }
}
