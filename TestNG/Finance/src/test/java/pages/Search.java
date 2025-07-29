package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {


    @FindBy(className="search-box")
    public WebElement txtsearch;




    // Defining Constructor by the name of Class name
    public Search(WebDriver driver){


        PageFactory.initElements(driver,this);

    }

    public void doSearch(String str){

        txtsearch.sendKeys(str);
        //txtsearch.submit();


    }


}
