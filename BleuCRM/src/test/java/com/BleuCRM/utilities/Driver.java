package com.BleuCRM.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {

    static String browser;
    /*
    Creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */
    private Driver(){}

    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */
    //private static WebDriver driver; // value is null by default

    private static WebDriver driver;

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */

    public static WebDriver getDriver(){

        if (driver == null){

            if (System.getProperty("BROWSER") == null) {
                browser = ConfigurationReader.getProperty("browser");
            } else {
                browser = System.getProperty("BROWSER");
            }
            System.out.println("Browser: " + browser);
            switch (browser) {
                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "3.85.203.69"; //this ip is not working I should create new aws machine and download docker image for sel.grid can work
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                       driver= new RemoteWebDriver(url, desiredCapabilities);
                        driver.manage().window().maximize();
                        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                // to disable of the Chrome notifications that might pop up in our browser
                case "chrome_notification_handled":
                    WebDriverManager.chromedriver().setup();
                    // Create a map to store  preferences
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    // add key and value to map as follow to switch off browser notification
                    // Pass the argument 1 to allow and 2 to block
                    // 1-Allow, 2-Block, 0-default
                    prefs.put("profile.default_content_setting_values.notifications", 2);
                    //Create an instance of ChromeOptions
                    ChromeOptions options = new ChromeOptions();
                    // set ExperimentalOption - prefs
                    options.setExperimentalOption("prefs", prefs);
                    //Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver
                    // which will switch off this browser notification on the chrome browser
                    driver= new ChromeDriver(options);
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;


                case "edge":
                    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your operating system does not support the requested browser");
                    }
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;

                case "safari":
                    if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your operating system does not support the requested browser");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver=new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;
            }
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
