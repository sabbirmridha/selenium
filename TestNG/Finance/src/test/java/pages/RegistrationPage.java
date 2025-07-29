package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegistrationPage {

    @FindBy(tagName ="a")
    //public WebElement btnRegister;
    public List<WebElement> btnRegister;

    @FindBy(id="firstName")
    public WebElement txtFName;

    @FindBy(id="lastName")
    public WebElement txtLName;

    @FindBy(id="email")
    public WebElement  txtEmail;

    @FindBy(id="password")
    public WebElement txtPassword;

    @FindBy(id="phoneNumber")
    public WebElement txtNumber;

    @FindBy(id="address")
    public WebElement txtAddress;

    @FindBy(css = "[type=radio]")
    public List<WebElement> rbtnGender;

    @FindBy(css="[type=checkbox]")
    public WebElement checkAcceptTC;

    @FindBy(id = "register")
    public WebElement btnRegisterSubmit;

    // Defining Constructor by the name of Class name
    public RegistrationPage(WebDriver driver){

        PageFactory.initElements(driver , this);

    }



    public void doRegister(String firstName, String lastName,String email, String password,String phoneNumber, String address ){

        //btnRegister.click();--> [Note: wrote in RegistrationTestRunner page due to good practise ]
        txtFName.sendKeys(firstName);
        txtLName.sendKeys(lastName);
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        txtNumber.sendKeys(phoneNumber);
        txtAddress.sendKeys(address);
        rbtnGender.get(0).click();
        checkAcceptTC.click();
        btnRegisterSubmit.click();


        



    }

}
