package systemTesting.pom.pageObjectRefactor.createAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountActions extends CreateAccountObject{

    private WebDriver driver;
    private  WebDriverWait wait;

    public CreateAccountActions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void createAccountProcess(){
        sendsKeysFirstName("test");
        sendsKeyLastName("test1");
        sendsKeysEmail("test@gmail.com");
        sendsKeysPasswords("test");
        sendsKeysPasswordRepeat("test");
        clickRegisterButton();
    }

    private void sendsKeysFirstName(String firstNameText){
        firstName.sendKeys(firstNameText);
    }

    private void sendsKeyLastName(String lastNameText){
        lastName.sendKeys(lastNameText);
    }

    private void sendsKeysEmail(String emailText){
        email.sendKeys(emailText);
    }

    private void sendsKeysPasswords(String passwordsText){
        password.sendKeys(passwordsText);
    }

    private void sendsKeysPasswordRepeat(String passwordText){
        repeatPassword.sendKeys(passwordText);
    }

    private void clickRegisterButton(){
        register.click();
    }
}
