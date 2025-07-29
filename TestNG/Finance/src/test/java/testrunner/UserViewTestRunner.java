package testrunner;
import config.Setup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Search;
import pages.UserView;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UserViewTestRunner extends Setup {


    LoginPage loginPage;
    Search searchPage;
    UserView  viewPage;

    public void vLogin() {

        loginPage = new LoginPage(driver); // inherited driver from config.Setup Class.
        loginPage.doLogin("admin@test.com", "admin123");


    }

    public void vSearch(){


        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        searchPage = new Search(driver);
        searchPage.doSearch("sabbir");




        String MessageActual = driver.findElement(By.className("total-count")).getText();
        String MessageExpected = "Total Users: 1";

        // Assertion
        Assert.assertTrue(MessageActual.contains(MessageExpected));





    }

    @Test
    public void doView(){

        vLogin();
        vSearch();

        viewPage = new UserView(driver);
        viewPage.doView();



        String headerActual = driver.findElement(By.tagName("h4")).getText();
        String headerExpected="User Details";

        // Assertion to get the text

        Assert.assertTrue(headerActual.contains(headerExpected));


    }



































}
