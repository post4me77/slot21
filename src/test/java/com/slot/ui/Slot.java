package com.slot.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.slot.BasePageObject;

public class Slot extends BasePageObject {

    public Slot(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\"login\"]")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"email_create\"]")
    WebElement emailCreateField;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
    WebElement submitCreateButton;

    @FindBy(xpath = "//*[@id=\"id_gender1\"]")
    WebElement id_genderButton;

    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    WebElement customerFirstnameField;

    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    WebElement customerLastname;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    WebElement passwdField;

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    WebElement firstnameField;

    @FindBy(xpath = "//*[@id=\"lastname\"]")
    WebElement lastnameField;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    WebElement address1Field;

    @FindBy(xpath = "//*[@id=\"city\"]")
    WebElement cityField;

    @FindBy(xpath = "//*[@id=\"postcode\"]")
    WebElement postcodeField;

    @FindBy(xpath = "//*[@id=\"phone_mobile\"]")
    WebElement phone_mobileField;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]")
    WebElement submitAccountButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]")
    WebElement center_column;

    @FindBy(xpath = "//*[@id=\"id_state\"]/option[6]")
    WebElement id_stateField;

    public void setElementText(WebElement element, String text) throws InterruptedException {
        waitUntilElementIsLoaded(element);
        element.sendKeys(text);
    }

    public void waitForElement(WebElement element) throws InterruptedException {
        waitUntilElementIsLoaded(element);
    }

    public void setCountry() {
        id_stateField.click();
//        WebElement country = driver
//                .findElement((By.xpath("//*[contains(text(), \"" + country + "\")]")));
//        country.click();
    }
}
