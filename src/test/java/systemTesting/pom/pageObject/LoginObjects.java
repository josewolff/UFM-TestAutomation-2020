package systemTesting.pom.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginObjects {

    private WebDriver driver;
    private  WebDriverWait wait;

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement login;

    public LoginObjects(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public boolean isVisibleLoginButton(){
        try{
            wait.until(ExpectedConditions.visibilityOf(login));
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
