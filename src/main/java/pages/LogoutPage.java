package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutPage extends BaseClass {

    public void logout() {
        hold(2);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("oxd-userdropdown-tab"))).click();
        hold(1);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        System.out.println("Logout successful");

    }
}