package testrunner;

import config.Setup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestRunner extends Setup {


    LoginPage loginPage;

    // Login using Wrong Email address
    @Test (priority = 1)
    public void LoginWrongEmail() {

        loginPage = new LoginPage(driver); // inherited driver from config.Setup Class.
        loginPage.doLogin("admin@test12.com", "admin123");

        String errorMessageActual = driver.findElement(By.tagName("p")).getText();
        String errorMessageExpected = "Invalid email or password";

        // Assertion to get the text

        Assert.assertTrue(errorMessageActual.contains(errorMessageExpected));

        driver.navigate().refresh(); // // To reload the browser


    }


    // Login with incorrect Password

    @Test (priority = 2)
    public void LoginWrongPass() {

        loginPage = new LoginPage(driver); // inherited driver from config.Setup Class.
        loginPage.doLogin("admin@test.com", "admin12355656");

        String errorMessageActual = driver.findElement(By.tagName("p")).getText();
        String errorMessageExpected = "Invalid email or password";

        // Assertion to get the text

        Assert.assertTrue(errorMessageActual.contains(errorMessageExpected));
        driver.navigate().refresh(); // To reload the browser

    }



    //Login with Correct Credentials


    @Test(priority = 3)
    public void myLogin(){

        loginPage=new LoginPage(driver); // inherited driver from config.Setup Class.
        loginPage.doLogin("admin@test.com", "admin123");

        String headerActual = driver.findElement(By.tagName("h2")).getText();
        String headerExpected="Admin Dashboard";

        // Assertion to get the text

        Assert.assertTrue(headerActual.contains(headerExpected));





    }

}
