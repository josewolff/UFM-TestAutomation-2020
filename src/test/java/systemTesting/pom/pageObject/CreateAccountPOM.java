package systemTesting.pom.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import systemTesting.InitDriver;
import systemTesting.pom.pageObject.CreateAccountObject;
import systemTesting.pom.pageObject.LoginObjects;

public class CreateAccountPOM extends InitDriver {

    private CreateAccountObject createAccountObject;
    private LoginObjects loginObjects;

    @BeforeClass(alwaysRun = true)
    public void initUrl(){
        driver.get("http://localhost:8080/register.html");
        createAccountObject =  new CreateAccountObject(driver, wait);
        loginObjects =  new LoginObjects(driver, wait);

    }

    @Test(groups = {"CreateUserPom"})
    public void CreateUserPom()  {
        createAccountObject.createAccountProcess();
        boolean isPresentTheButton = loginObjects.isVisibleLoginButton();
        if(!isPresentTheButton){
            Assert.fail("No se encontro el elemento de login");
        }
    }
}