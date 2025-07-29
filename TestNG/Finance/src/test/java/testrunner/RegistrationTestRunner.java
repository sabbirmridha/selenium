package testrunner;

import config.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.time.Duration;

public class RegistrationTestRunner extends Setup {


    @Test
    public void userReg() {



        RegistrationPage regPage= new RegistrationPage(driver);

        regPage.btnRegister.get(1).click(); ;

        String firstName="SamTest0456";
        String lastName="Utsho043252";
        String email="sam_2025513452@gmail.com";
        String password="5678";
        String phoneNumber="011745211221";
        String address="Faridpur";
        regPage.doRegister(firstName,lastName,email,password,phoneNumber,address);




       // Thread.sleep(2000); // [NB: though this is a bad practise but as instead of using explicit waiter our work did not resolve thats why bound to use it.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50)); //explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast")));
        String successfulMessageActual= driver.findElement(By.className("Toastify__toast")).getText();
        String successfulMessageExpected="registered successfully!";
        System.out.println(successfulMessageActual);





    }


}
