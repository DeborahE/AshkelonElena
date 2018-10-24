package com.telRan.mish.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private UserHelper userHelper;
    private SessionHelper sessionHelper;

    WebDriver wd;

    public void start() {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability("applicationCacheEnabled", false);

        // ChromeOptions options = new ChromeOptions();
        //wd = new ChromeDriver(options.addArguments("--disable-notifications"));

        wd=new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wd.navigate().to("https://mish.sheygam.com/#/wellcome");

        sessionHelper = new SessionHelper(wd);
        userHelper = new UserHelper(wd);
    }

    public void stop() {
        wd.quit();
    }


    public boolean isHamburgerDisplayed() {
        return wd.findElement(By.xpath("//img[@id='borderRadius']")).isDisplayed();
    }


    public void submitLogin() {
        wd.findElement(By.xpath("//span[contains(text(),'Log in')]")).click();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }



}