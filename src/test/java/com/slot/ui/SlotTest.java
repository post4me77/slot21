package com.slot.ui;

import java.io.IOException;

import org.junit.jupiter.api.*;

import com.slot.DriverFactory;
import com.slot.ReadPropertyFile;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SlotTest {
    static DriverFactory objDriver = new DriverFactory();
    ReadPropertyFile readPropertyFile = new ReadPropertyFile();
    static Slot slot;
    String BASEURL = "http://automationpractice.com";
    String EMAIL = "sfdsf@dksjdk7s.com";
    String COUNTRY = "California";
    String DIGITAL = "12345";

    @BeforeAll
    static void setUp() throws IOException, InterruptedException {
        slot = new Slot(objDriver.getDriver());
        slot.setWindowsSize(ReadPropertyFile.getVallueWithComma("size").get(0),
                ReadPropertyFile.getVallueWithComma("size").get(1));
    }

    @BeforeEach
    public void load() throws IOException, InterruptedException {
        objDriver.getDriver().navigate().to(BASEURL);
        slot.waitForElement(slot.signInButton);
    }

    @AfterAll
    static void tearDown() {
        objDriver.quitDriver();
    }

    @AfterEach
    public void clearSession() {
        objDriver.deleteCookies();
    }

    @Test
    public void test1() throws InterruptedException, IOException {
        slot.signInButton.click();
        slot.setElementText(slot.emailCreateField, EMAIL);
        slot.submitCreateButton.click();
        slot.waitForElement(slot.id_genderButton);
        slot.id_genderButton.click();
        slot.setElementText(slot.customerFirstnameField, EMAIL);
        slot.setElementText(slot.customerLastname, EMAIL);
        slot.setElementText(slot.passwdField, EMAIL);
        slot.setElementText(slot.firstnameField, EMAIL);
        slot.setElementText(slot.lastnameField, EMAIL);
        slot.setElementText(slot.address1Field, EMAIL);
        slot.setElementText(slot.cityField, EMAIL);
        slot.setCountry();
        slot.setElementText(slot.postcodeField, DIGITAL);
        slot.setElementText(slot.phone_mobileField, DIGITAL);
        slot.submitAccountButton.click();
        slot.waitForElement(slot.center_column);
        assertTrue(slot.center_column.isDisplayed(), "ok");
    }
}
