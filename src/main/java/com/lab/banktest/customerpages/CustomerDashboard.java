package com.lab.banktest.customerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerDashboard {
    private final WebDriver driver;

    public CustomerDashboard(WebDriver driver) {
        this.driver = driver;
    }

    private final By userSelectDropDown = By.id("userSelect");
    private static By loginButton = By.cssSelector("body > div > div > div.ng-scope > div > form > button");

    private Select findCustomerNameDropDwn () {
        return new Select(driver.findElement(userSelectDropDown));
    }

    public void selectCustomerName(String customerName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userSelectDropDown));
        findCustomerNameDropDwn().selectByVisibleText(customerName);
    }

    public CustomerAccountDashboard clickLoginButton(){
        driver.findElement(loginButton).click();
        return new CustomerAccountDashboard(driver);
    }


}
