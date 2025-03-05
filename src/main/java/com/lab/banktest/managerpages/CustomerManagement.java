package com.lab.banktest.managerpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerManagement {
    WebDriver driver;

    public CustomerManagement(WebDriver driver) {
        this.driver = driver;
    }
    private static By homeButton = By.cssSelector("body > div > div > div.box.mainhdr > button.btn.home");

    public void deleteCustomer(String firstName, String lastName) {

        String xpath = "//tr[td[1][normalize-space()='" + firstName + "'] and td[2][normalize-space()='" + lastName + "']]//button[text()='Delete']";
        By deleteButtonLocator = By.xpath(xpath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(deleteButtonLocator));
        driver.findElement(deleteButtonLocator).click();
    }

    public void goHome(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeButton));
        driver.findElement(homeButton).click();
    }




}
