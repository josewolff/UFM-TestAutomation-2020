package systemTesting.pom.pageObjectRefactor;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import systemTesting.InitDriver;
import systemTesting.pom.pageObjectRefactor.createAccount.CreateAccountActions;
import systemTesting.pom.pageObjectRefactor.logIn.LoginActions;

public class CreateAccountPOMRefactor extends InitDriver {

    private CreateAccountActions createAccountActions;
    private LoginActions loginActions;

    @BeforeClass(alwaysRun = true)
    public void initUrl(){
        driver.get("http://localhost:8080/register.html");
        createAccountActions =  new CreateAccountActions(driver, wait);
        loginActions =  new LoginActions(driver, wait);

    }

    @Test(groups = {"CreateUserPomRefactor"})
    public void CreateUserPomRefactor()  {
        createAccountActions.createAccountProcess();
        boolean isPresentTheButton = loginActions.isVisibleLoginButton();
        if(!isPresentTheButton){
            Assert.fail("No se encontro el elemento de login");
        }
    }
}