package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class LocationPage extends BaseClass {

    public void addLocation(String name, String city, String state, String zip, String phone) {
        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Admin']/ancestor::a")));
        driver.findElement(By.xpath("//span[text() = 'Admin']/ancestor::a")).click();

        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Organization ']/ancestor::li")));
        driver.findElement(By.xpath("//*[text() = 'Organization ']/ancestor::li")).click();
        hold(2);
        driver.findElement(By.xpath("//a[contains(text(), 'Locations')]/ancestor::li[1]")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = ' Add ']")));
        driver.findElement(By.xpath("//button[text() = ' Add ']")).click();

        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text() = \"Name\"]/ancestor::div[1]/following-sibling::div/input")));
        driver.findElement(By.xpath("//label[text() = \"Name\"]/ancestor::div[1]/following-sibling::div/input")).sendKeys(name);
        hold(1);
        driver.findElement(By.xpath("//label[text() = \"City\"]/ancestor::div[1]/following-sibling::div/input")).sendKeys(city);
        hold(1);
        driver.findElement(By.xpath("//label[text() = \"State/Province\"]/ancestor::div[1]/following-sibling::div/input")).sendKeys(state);
        hold(1);
        driver.findElement(By.xpath("//label[text() = \"Zip/Postal Code\"]/ancestor::div[1]/following-sibling::div/input")).sendKeys(zip);

        driver.findElement(By.xpath("//div[contains(text(), \"Select\")]")).click();
        hold(1);
        driver.findElement(By.xpath("//span[text() = 'India']")).click();
        hold(1);
        driver.findElement(By.xpath("//label[text() = \"Phone\"]/ancestor::div[1]/following-sibling::div/input")).sendKeys(phone);
        hold(1);

        WebElement submit = driver.findElement(By.xpath("//*[@type = 'submit']"));

        js.executeScript("arguments[0].scrollIntoView(true);", submit);
        submit.click();
    }

    public void deleteLocation(String location) {
        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Admin']/ancestor::a")));
        driver.findElement(By.xpath("//span[text() = 'Admin']/ancestor::a")).click();

        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Organization ']/ancestor::li")));
        driver.findElement(By.xpath("//*[text() = 'Organization ']/ancestor::li")).click();
        hold(2);
        driver.findElement(By.xpath("//a[contains(text(), 'Locations')]/ancestor::li[1]")).click();

        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = '"+location+"']/ancestor::div[3]//button[1]")));
        WebElement button = driver.findElement(By.xpath("//div[text() = '"+location+"']/ancestor::div[3]//button[1]"));
        js.executeScript("arguments[0].scrollIntoView(true)", button);

        action.moveToElement(button).perform();

        hold(2);
        button.click();

        hold(2);
        WebElement confirm = driver.findElement(By.xpath("//button[text() = ' Yes, Delete ']"));
        action.moveToElement(confirm).perform();

        confirm.click();
    }

}