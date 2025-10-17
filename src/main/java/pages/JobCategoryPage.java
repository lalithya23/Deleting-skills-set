package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;


public class JobCategoryPage extends BaseClass {
    public void addJobCategory(String jobCategory) {
        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Admin']/ancestor::a")));
        driver.findElement(By.xpath("//span[text() = 'Admin']/ancestor::a")).click();

        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Job ']/ancestor::li")));
        driver.findElement(By.xpath("//*[text() = 'Job ']/ancestor::li")).click();

        hold(1);
        //wait.until(ExpectedConditions.visibilityOfElementLocated());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Job Categories')]/ancestor::li[1]")));
        driver.findElement(By.xpath("//a[contains(text(), 'Job Categories')]/ancestor::li[1]")).click();

        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = ' Add ']")));
        driver.findElement(By.xpath("//button[text() = ' Add ']")).click();

        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text() = \"Name\"]/ancestor::div[1]/following-sibling::div/input")));
        driver.findElement(By.xpath("//label[text() = \"Name\"]/ancestor::div[1]/following-sibling::div/input")).sendKeys(jobCategory);
        driver.findElement(By.xpath("//*[@type = 'submit']")).click();

    }

    public void deleteJobCategory(String jobCategory) {
        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Admin']/ancestor::a")));
        driver.findElement(By.xpath("//span[text() = 'Admin']/ancestor::a")).click();

        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Job ']/ancestor::li")));
        driver.findElement(By.xpath("//*[text() = 'Job ']/ancestor::li")).click();

        hold(1);
        driver.findElement(By.xpath("//a[contains(text(), 'Job Categories')]/ancestor::li[1]")).click();

        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = '"+jobCategory+"']/ancestor::div[3]//following-sibling::div//button[1]")));
        WebElement deleteButton = driver.findElement(By.xpath("//div[text() = '"+jobCategory+"']/ancestor::div[3]//following-sibling::div//button[1]"));

        wait.until(ExpectedConditions.visibilityOf(deleteButton));

        js.executeScript("arguments[0].scrollIntoView(true);", deleteButton);

        action.moveToElement(deleteButton).perform();


        hold(2);
        deleteButton.click();

        hold(2);
        WebElement confirm = driver.findElement(By.xpath("//button[text() = ' Yes, Delete ']"));
        action.moveToElement(confirm).perform();

        confirm.click();
    }
}