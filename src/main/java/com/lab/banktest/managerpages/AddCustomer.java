package com.lab.banktest.managerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCustomer {
    private final WebDriver driver;

    public AddCustomer(WebDriver driver) {
        this.driver = driver;
    }

    //Finding the input fields for Firstname, Lastname, Postal code and add customer button
    private final By firstNameField = By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(1) > input");
    private final By lastNameField =By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(2) > input");
    private final By postalCodeField = By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(3) > input");
    private final By submitButton = By.cssSelector("body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > button");



    // creating a method to set all the specified fields
    public void setFirstNameField (String firstname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys(firstname);
    }

    public void setLastNameField(String lastname) {
        driver.findElement(lastNameField).sendKeys(lastname);
    }

    public void setPostalCodeField(String postalCd) {
        driver.findElement(postalCodeField).sendKeys(postalCd);
    }

    public OpenAccount clickSubmitButton(){
        driver.findElement(submitButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        return new OpenAccount(driver);
    }


}
