package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class SkillsPage extends BaseClass {
public void addSkill(String skill) {
    hold(2);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Admin']/ancestor::a")));
    driver.findElement(By.xpath("//span[text() = 'Admin']/ancestor::a")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Qualifications ']")));
    driver.findElement(By.xpath("//*[text() = 'Qualifications ']/ancestor::li")).click();

    hold(1);
    driver.findElement(By.xpath("//a[contains(text(), 'Skills')]/ancestor::li[1]")).click();

    hold(2);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = ' Add ']")));
    driver.findElement(By.xpath("//button[text() = ' Add ']")).click();

    hold(1);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text() = \"Name\"]/ancestor::div[1]/following-sibling::div/input")));
    driver.findElement(By.xpath("//label[text() = \"Name\"]/ancestor::div[1]/following-sibling::div/input")).sendKeys(skill);
    hold(1);
    driver.findElement(By.xpath("//*[@type = 'submit']")).click();
}

    public void deleteSkill(String skill) {
        hold(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Admin']/ancestor::a")));
        driver.findElement(By.xpath("//span[text() = 'Admin']/ancestor::a")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Qualifications ']")));
        driver.findElement(By.xpath("//*[text() = 'Qualifications ']/ancestor::li")).click();

        hold(1);
        driver.findElement(By.xpath("//a[contains(text(), 'Skills')]/ancestor::li[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = '"+skill+"']/ancestor::div[3]//following-sibling::div//button[1]")));
        hold(1);
        WebElement addedSkill = driver.findElement(By.xpath("//div[text() = '"+skill+"']/ancestor::div[3]//following-sibling::div//button[1]"));

        js.executeScript("arguments[0].scrollIntoView", addedSkill);
        action.moveToElement(addedSkill).perform();

        hold(1);
        addedSkill.click();

        hold(2);
        WebElement confirm = driver.findElement(By.xpath("//button[text() = ' Yes, Delete ']"));
        action.moveToElement(confirm).perform();

        confirm.click();
    }
}