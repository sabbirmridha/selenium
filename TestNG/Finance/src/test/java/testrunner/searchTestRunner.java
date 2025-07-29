package testrunner;
import config.Setup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Search;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class searchTestRunner extends Setup {


    LoginPage loginPage;
    Search searchPage;


    public void yLogin() {

        loginPage = new LoginPage(driver); // inherited driver from config.Setup Class.
        loginPage.doLogin("admin@test.com", "admin123");


    }


    @Test
    public void mySearch(){

        yLogin();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        searchPage = new Search(driver);
        searchPage.doSearch("sabbir");




        String MessageActual = driver.findElement(By.className("total-count")).getText();
        String MessageExpected = "Total Users: 1";

        // Assertion
        Assert.assertTrue(MessageActual.contains(MessageExpected));





    }














}
