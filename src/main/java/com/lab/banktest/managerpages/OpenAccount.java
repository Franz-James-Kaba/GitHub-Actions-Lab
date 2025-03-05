package com.lab.banktest.managerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OpenAccount {
    private final WebDriver driver;

    public OpenAccount(WebDriver driver) {
        this.driver = driver;
    }

    private final By customerDropdown = By.id("userSelect");
    private final By currencyDropDown = By.id("currency");
    private final By processButton = By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > button");

    public void selectCustomerDropDwn(String customerName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerDropdown));
        findCustomerDropdownElement().selectByVisibleText(customerName);
    }

    public void setCurrencyDropDown(String currency){
        findCurrencyDropdownElement().selectByVisibleText(currency);
    }

    private Select findCustomerDropdownElement() {
        return new Select(driver.findElement(customerDropdown));
    }

    private Select findCurrencyDropdownElement() {
        return new Select(driver.findElement(currencyDropDown));
    }

    public CustomerManagement clickProcessButton(){
        driver.findElement(processButton).click();
        return new CustomerManagement(driver);
    }






}
