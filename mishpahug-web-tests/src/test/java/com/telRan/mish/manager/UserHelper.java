package com.telRan.mish.manager;

import com.telRan.mish.model.NotRegisteredUser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {
        super(wd);

    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//span[contains(.,'Registration')]"));
    }

    public void fillCreateAccountForm(NotRegisteredUser notRegUser) {
        type(By.cssSelector("[formcontrolname=email]"), notRegUser.getMyEmail());
        type(By.cssSelector("[formcontrolname=password]"), notRegUser.getPassword());
        type(By.cssSelector("[formcontrolname=passwordRep]"), notRegUser.getPasswordRep());
    }

    public void clickOnCreateAccountButtonOnHeader() {
        click(By.cssSelector("a.paddingLeft.hover.but.mat-button:last-child"));
    }

    public void openCreateAccountForm() {
        click(By.xpath("//span[contains(., 'Registration')]"));

    }

    public void clickOnLogoutButton() {
        click(By.xpath("//span[contains(text(),'Log out')]"));
    }

    public void FillLoginForm(String email, String password) {
        type(By.cssSelector("input[formcontrolname=email]"), email);
        type(By.cssSelector("input[formcontrolname=password]"), password);
    }

    public boolean isOnRegistrationPage() {
        return isElementPresent(By.cssSelector(".avatar"));
    }

    public void fillPersonnalInformationForm(String fName, String lName, String phoneNumber, String religious, String year, String month, String day) throws InterruptedException {
        type(By.id("inputFirstName"), fName);
        type(By.id("inputLastName"), lName);
        type(By.id("inputPhoneNumber"), phoneNumber);
        click(By.cssSelector("[placeholder=Confession]"));
        click(By.xpath("//*[contains(text(),'" + religious + "')]"));
        enterDate(year, month, day);
        return;


    }

    public void enterDate(String year, String month, String day) throws InterruptedException {
        waitAndClick(3000, By.xpath("//*[@aria-label='Open calendar']"));
        waitAndClick(3000, By.xpath("//*[@aria-label='Choose month and year']"));

        Thread.sleep(3000);
        // select year
        while(!isYearPresent(year)){
            click(By.xpath("//*[@aria-label='Previous 20 years']"));
        }
        waitAndClick(3000, By.xpath("//*[contains(text(),'" + year + "')]"));
        waitAndClick(3000, By.xpath("//*[contains(text(),'" + month + "')]"));
        waitAndClick(3000, By.xpath("//div[contains(text(),'" + day + "')]"));
        Thread.sleep(3000);
    }

    private boolean isYearPresent(String year) {

        return isElementPresent(By.xpath("//*[contains(text(),'" + year + "')]"));
    }


    public void fillAboutMyselfForm(String maritalStatus, String food, String gender, String language, String description) throws InterruptedException {

        // Marital Status

        chooseOption("Marital Status", maritalStatus);


        // Food Preference
        chooseOption("Food Preferences", food);

        escape();


        // Gender
        chooseOption("Gender", gender);


        // Language
        chooseOption("Languages", language);
        escape();

        //Write few words about yourself.

        type(By.cssSelector("[placeholder='Write few words about yourself.']"), description);

    }

    public void chooseOption(String field, String myChoice) throws InterruptedException {
        waitAndClick(3000, By.cssSelector("[placeholder='"+ field +"']"));
        waitAndClick(3000,By.xpath("//*[contains(text(),'" + myChoice + "')]"));
    }

    public void chooseTwoOptions(String field, String myChoice, String myChoice2) throws InterruptedException {
        waitAndClick(3000, By.cssSelector("[placeholder='"+ field +"']"));
        waitAndClick(3000,By.xpath("//*[contains(text(),'" + myChoice + "')]"));
        waitAndClick(3000,By.xpath("//*[contains(text(),'" + myChoice2 + "')]"));
    }

    public void chooseThreeOptions(String field, String myChoice, String myChoice2, String myChoice3) throws InterruptedException {
        waitAndClick(3000, By.cssSelector("[placeholder='"+ field +"']"));
        waitAndClick(3000,By.xpath("//*[contains(text(),'" + myChoice + "')]"));
        waitAndClick(3000,By.xpath("//*[contains(text(),'" + myChoice2 + "')]"));
        waitAndClick(3000,By.xpath("//*[contains(text(),'" + myChoice3 + "')]"));
    }

}



