package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

   // driver.findElement(By.cssSelector("[type='button']"))


    @FindBy(id="email")
    public WebElement txtemail;

    @FindBy(id="password")
    public WebElement txtPassword;

    @FindBy(tagName ="button")
    public WebElement btnLogin; //For Login form Submission





    // Defining Constructor by the name of Class name
    public LoginPage(WebDriver driver){


        PageFactory.initElements(driver,this);

    }

    public void doLogin(String email,String password ){


        txtemail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

}
