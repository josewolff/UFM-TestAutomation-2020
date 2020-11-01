package systemTesting;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.GlobalVariables;

public class CreateAccount extends InitDriver {

    @BeforeClass(alwaysRun = true)
        public void initUrl(){
            driver.get(GlobalVariables.registerSeleniumHost);

        }

        @Test(groups = {"CreateUser"})
        public void CreateUser() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleFirstName"))).sendKeys("Jose");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleLastName"))).sendKeys("Wolff");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[contains(@type,'email')]"))).sendKeys("wolff@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[contains(@class,'form-control') and @placeholder='Password']"))).
                sendKeys("test");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleRepeatPassword"))).sendKeys("test");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Register Account')]"))).click();
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'login')]")));
            System.out.println(driver.getCurrentUrl());
        }catch(Exception e){
            Assert.fail("No se encontro el elemento de login");
        }

    }
}
//