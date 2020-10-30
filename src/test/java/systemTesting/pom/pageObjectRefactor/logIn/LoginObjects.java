package systemTesting.pom.pageObjectRefactor.logIn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObjects {

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    protected WebElement login;

}
