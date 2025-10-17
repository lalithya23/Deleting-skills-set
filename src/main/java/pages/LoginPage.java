package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseClass {

    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//*[@type='submit']");

    public void login(String uname, String pwd) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(uname);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginBtn).click();
        System.out.println("Login successful");
    }
}