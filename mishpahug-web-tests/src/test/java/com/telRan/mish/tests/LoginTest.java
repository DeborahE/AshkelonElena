package com.telRan.mish.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preconditions(){
        if(app.getSessionHelper().isLoggedIn()){
            app.getSessionHelper().logOut();
        }
    }


    @Test

    public void testLoginRegistredUser() throws InterruptedException {
        app.getSessionHelper().clickOnLoginButtonOnHeader();
        app.getUserHelper().FillLoginForm("qa15@bii.com","a123456");
        app.submitLogin();

        Thread.sleep(3000);
        Assert.assertTrue(app.getSessionHelper().isLoggedIn());
    }
}
