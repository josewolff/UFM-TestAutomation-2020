package systemTesting.pom.pageObjectRefactor.createAccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountObject {

    @FindBy(id = "exampleFirstName")
    protected WebElement firstName;

    @FindBy(id = "exampleLastName")
    protected WebElement lastName;

    @FindBy(xpath = "//div/input[contains(@type,'email')]")
    protected WebElement email;

    @FindBy(xpath = "//div/input[contains(@class,'form-control') and @placeholder='Password']")
    protected WebElement password;

    @FindBy(id = "exampleRepeatPassword")
    protected WebElement repeatPassword;

    @FindBy(xpath = "//a[contains(text(),'Register Account')]")
    protected WebElement register;



}


