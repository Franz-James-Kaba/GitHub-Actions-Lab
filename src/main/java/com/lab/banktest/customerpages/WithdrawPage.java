package com.lab.banktest.customerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WithdrawPage {
    private final WebDriver driver;

    public WithdrawPage(WebDriver driver) {
        this.driver = driver;
    }
    private final static By amountField = By.cssSelector("body > div > div > div.ng-scope > div > div:nth-child(5) > button.btn.btn-lg.tab.btn-primary");
    private final static By withdrawButton = By.cssSelector("body > div > div > div.ng-scope > div > div.container-fluid.mainBox.ng-scope > div > form > button");
    private final static By balanceValue = By.xpath("//div[contains(@class, 'center')]//strong[2]");

    public void inputAmount(String amount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));
        driver.findElement(amountField).sendKeys(amount);
    }

    public void clickWithdrawButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(withdrawButton));
        driver.findElement(withdrawButton).click();
    }
    public String getBalanceAmount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(balanceValue));
        String actualAmount = driver.findElement(balanceValue).getText().trim();
        return actualAmount;
    }


}
