package com.telRan.mish.tests;

import com.telRan.mish.model.NotRegisteredUser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {


  @BeforeMethod
  public void preConditions(){
      app.getSessionHelper().deleteCookies();
  }



    @Test
  public void registerFromHeaderTest() throws InterruptedException {
    String myEmail = "etr+"+ System.currentTimeMillis() + "@gmail.com";
    System.out.println(myEmail);

    app.getUserHelper().clickOnCreateAccountButtonOnHeader();
    Thread.sleep(3000);
    app.getUserHelper().fillCreateAccountForm(new NotRegisteredUser()
            .setMyEmail(myEmail)
            .setPassword("a123456")
            .setPasswordRep("a123456"));
        Thread.sleep(3000);
    app.getUserHelper().clickOnRegistrationButton();
        Thread.sleep(3000);

    //Assert.assertTrue(app.getUserHelper().isOnRegistrationPage());
        // Fill account form

        app.getUserHelper().fillPersonnalInformationForm("Moshe", "Cohen", "0123456789", "Religious", "1972", "JAN", "19");
        app.getUserHelper().fillAboutMyselfForm("Married", "Kosher", "Male","French", "Something about myself");
  }



    @Test
 public void registrationFromLoginForm() throws InterruptedException {
        String myEmail = "etr+"+ System.currentTimeMillis() + "@gmail.com";
        System.out.println(myEmail);
    app.getSessionHelper().clickOnLoginButtonOnHeader();
        Thread.sleep(3000);
    app.getUserHelper().openCreateAccountForm();
        Thread.sleep(3000);
    app.getUserHelper().fillCreateAccountForm(new NotRegisteredUser()
            .setMyEmail(myEmail)
            .setPassword("a123456")
            .setPasswordRep("a123456"));
        Thread.sleep(3000);
    app.getUserHelper().clickOnRegistrationButton();

    Assert.assertTrue(app.isHamburgerDisplayed());
        Thread.sleep(3000);



  }



  @Test
  public void registrationFromCreateEvent(){

  }

@AfterMethod
public void postCondition(){
  app.getSessionHelper().logOut();
}

}
