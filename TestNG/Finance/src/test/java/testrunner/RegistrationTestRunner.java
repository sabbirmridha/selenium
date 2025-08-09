package testrunner;

import com.github.javafaker.Faker;
import config.Setup;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class RegistrationTestRunner extends Setup {


    @Test
    public void userReg() throws IOException, ParseException {



        RegistrationPage regPage= new RegistrationPage(driver);

        Faker faker=new Faker();


        regPage.btnRegister.get(1).click(); ;

        // If need to generate fake data automatically using faker

        String firstName= faker.name().firstName();
        String lastName= faker.name().lastName();
        String email=faker.internet().emailAddress();
        String password="5678";
        String phoneNumber= "011501"+Utils.generateRandomNumber(100000,999999);
        String address=faker.address().fullAddress();
        regPage.doRegister(firstName,lastName,email,password,phoneNumber,address);





        /*

// For Giving User data -
        String firstName="MasTest0456";
        String lastName="Utsho043252";
        String email="Mas_2025513452@gmail.com";
        String password="5678";
        String phoneNumber="011745211221";
        String address="Faridpur";
        regPage.doRegister(firstName,lastName,email,password,phoneNumber,address);

        */

       // Thread.sleep(2000); // [NB: though this is a bad practise but as instead of using explicit waiter our work did not resolve thats why bound to use it.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50)); //explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast")));
        String successfulMessageActual= driver.findElement(By.className("Toastify__toast")).getText();
        String successfulMessageExpected="registered successfully!";
        System.out.println(successfulMessageActual);


        // To add automatically generated data in users.json file:

        JSONObject userObj=new JSONObject();
        userObj.put("firstName",firstName);
        userObj.put("lastName",lastName);
        userObj.put("email",email);
        userObj.put("password",password);
        userObj.put("phoneNumber",phoneNumber);
        userObj.put("address",address);



        Utils.storeUserInfo("./src/test/resources/users.json",userObj);





    }


}
