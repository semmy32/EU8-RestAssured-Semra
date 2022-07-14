package com.BleuCRM.step_definitions;

/*
In the class we will be able to pass pre- & post- conditions to
 each scenario and each step
 */

;
import com.BleuCRM.pages.LoginPage;
import com.BleuCRM.utilities.BrowserUtils;
import com.BleuCRM.utilities.ConfigurationReader;
import com.BleuCRM.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //import from io.cucumber.java not from junit
   // @Before
    public void setupScenario(){
        LoginPage loginpage=new LoginPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginpage.userLoginInput.sendKeys(ConfigurationReader.getProperty("username3"));
        loginpage.userPasswordInput.sendKeys(ConfigurationReader.getProperty("pw"));
        loginpage.loginBtn.click();
    }

    //@Before (value = "@login", order = 2)
    public void setupScenarioForLogins(){
        System.out.println("====this will only apply to scenarios with @login tag");
    }

    //@Before (value = "@db", order = 0)
    public void setupForDatabaseScenarios(){
        System.out.println("====this will only apply to scenarios with @db tag");
    }


    @After
    public void teardownScenario(Scenario scenario){

        Driver.closeDriver();
        //System.out.println("====Closing browser using cucumber @After");

    }

   // @BeforeStep
    public void setupStep(){
        System.out.println("--------> applying setup using @BeforeStep");
    }

   // @AfterStep
    public void afterStep(){
        //System.out.println("--------> applying tearDown using @AfterStep");
        Driver.closeDriver();
        BrowserUtils.waitFor(5);
    }


}
