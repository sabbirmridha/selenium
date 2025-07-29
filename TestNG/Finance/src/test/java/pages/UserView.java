package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserView {



    //driver.findElement(By.cssSelector("[type='button']"))


    @FindBy(css="[type='button']")
    List<WebElement> elements;




    // Defining Constructor by the name of Class name
    public UserView(WebDriver driver){


        PageFactory.initElements(driver,this);

    }

    public void doView(){



        elements.get(1).click();


    }




}
