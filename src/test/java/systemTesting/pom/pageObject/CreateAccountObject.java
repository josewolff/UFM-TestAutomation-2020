package systemTesting.pom.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountObject {

    private WebDriver driver;
    private  WebDriverWait wait;

    @FindBy(id = "exampleFirstName")
    WebElement firstName;

    @FindBy(id = "exampleLastName")
    WebElement lastName;

    @FindBy(xpath = "//div/input[contains(@type,'email')]")
    WebElement email;

    @FindBy(xpath = "//div/input[contains(@class,'form-control') and @placeholder='Password']")
    WebElement password;

    @FindBy(id = "exampleRepeatPassword")
    WebElement repeatPassword;

    @FindBy(xpath = "//a[contains(text(),'Register Account')]")
    WebElement register;

    public CreateAccountObject(WebDriver driver, WebDriverWait wait){
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


