package systemTesting.pom.pageObjectRefactor.logIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginActions extends LoginObjects{

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginActions(WebDriver driver, WebDriverWait wait){
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
