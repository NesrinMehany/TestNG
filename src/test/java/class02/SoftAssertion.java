package class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Class01.testNGExapmles.driver;

public class SoftAssertion {

    @Test
    public void invalidCredentials() {
        //username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
//        password
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("abracadabra");
//        login
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();
//        invalid credentials
        WebElement errorMSG = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
        String ActualErrorMsg = errorMSG.getText();
        String ExpectedErrorMsg = "Invalid credential";
//        if we want use soft Assertion we call it from the class SoftAssert by declaring an instance
        SoftAssert soft =new SoftAssert();
//        assertion
        soft.assertEquals(ActualErrorMsg,ExpectedErrorMsg);
//     /sout
        System.out.println("i am here after 1st assertion");
//        check if the webelement error message isDisplayed
        boolean isdisplayed=errorMSG.isDisplayed();
//        assertion
        soft.assertTrue(isdisplayed);
//  assert all the assertions that have been made
        soft.assertAll();
    }
}
