package testcases;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilities.ExcelUtils;

public class OrangeHRMTest extends BaseClass {

    LoginPage login;
    JobCategoryPage job;
    LocationPage location;
    SkillsPage skill;
    LogoutPage logout;

    @Parameters("browser")
    @BeforeTest
    public void setup(@Optional("chrome") String browser) {
        initializeBrowser(browser);
    }

    @BeforeClass
    public void setupPagesAndLogin() {
        login = new LoginPage();
        job = new JobCategoryPage();
        location = new LocationPage();
        skill = new SkillsPage();
        logout = new LogoutPage();

        String username = ExcelUtils.getData("LoginData", 1, 0);
        String password = ExcelUtils.getData("LoginData", 1, 1);
        login.login(username, password);
    }


    @DataProvider(name = "JobDataProvider")
    public Object[][] jobData() {
        int rows = ExcelUtils.getRowCount("JobData");
        Object[][] data = new Object[rows - 1][1];
        for (int i = 1; i < rows; i++) {
            data[i - 1][0] = ExcelUtils.getData("JobData", i, 0);
        }
        return data;
    }

    @DataProvider(name = "SkillDataProvider")
    public Object[][] skillData() {
        int rows = ExcelUtils.getRowCount("SkillData");
        Object[][] data = new Object[rows - 1][1];
        for (int i = 1; i < rows; i++) {
            data[i - 1][0] = ExcelUtils.getData("SkillData", i, 0);
        }
        return data;
    }

    @DataProvider(name = "LocationDataProvider")
    public Object[][] locationData() {
        int rows = ExcelUtils.getRowCount("LocationData");
        Object[][] data = new Object[rows - 1][5];
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < 5; j++) {
                data[i - 1][j] = ExcelUtils.getData("LocationData", i, j);
            }
        }
        return data;
    }

    public WebElement waitForToast() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oxd-toaster_1")));
    }


    @Test(priority = 1, dataProvider = "JobDataProvider")
    public void addJobCategory(String jobCategory) {
        try {
            job.addJobCategory(jobCategory);
            WebElement toast = waitForToast();
            Assert.assertTrue(toast.getText().contains("Successfully Saved"), "Job Category not Added");
            System.out.println("SUCCESS: Added Job Category: " + jobCategory);
        } catch (Exception e) {
            Assert.fail("Add Job Category failed: " + e.getMessage());
        }
    }

    @Test(priority = 2, dataProvider = "JobDataProvider")
    public void deleteJobCategory(String jobCategory) {
        try {
            job.deleteJobCategory(jobCategory);
            WebElement toast = waitForToast();
            Assert.assertTrue(toast.getText().contains("Successfully Deleted"), "Job Category not Deleted");
            System.out.println("SUCCESS: Deleted Job Category: " + jobCategory);
        } catch (Exception e) {
            Assert.fail("Delete Job Category failed: " + e.getMessage());
        }
    }

    @Test(priority = 3, dataProvider = "LocationDataProvider")
    public void addLocation(String locName, String city, String state, String zip, String phone) {
        try {
            location.addLocation(locName, city, state, zip, phone);
            WebElement toast = waitForToast();
            Assert.assertTrue(toast.getText().contains("Successfully Saved"), "Location not Added");
            System.out.println("SUCCESS: Added Location: " + locName);
        } catch (Exception e) {
            Assert.fail("Add Location failed: " + e.getMessage());
        }
    }

    @Test(priority = 4, dataProvider = "LocationDataProvider")
    public void deleteLocation(String locName, String city, String state, String zip, String phone) {
        try {
            location.deleteLocation(locName);
            WebElement toast = waitForToast();
            Assert.assertTrue(toast.getText().contains("Successfully Deleted"), "Location not Deleted");
            System.out.println("SUCCESS: Deleted Location: " + locName);
        } catch (Exception e) {
            Assert.fail("Delete Location failed: " + e.getMessage());
        }
    }

    @Test(priority = 5, dataProvider = "SkillDataProvider")
    public void addSkill(String skillName) {
        try {
            skill.addSkill(skillName);
            WebElement toast = waitForToast();
            Assert.assertTrue(toast.getText().contains("Successfully Saved"), "Skill not Added");
            System.out.println("SUCCESS: Added Skill: " + skillName);
        } catch (Exception e) {
            Assert.fail("Add Skill failed: " + e.getMessage());
        }
    }

    @Test(priority = 6, dataProvider = "SkillDataProvider")
    public void deleteSkill(String skillName) {
        try {
            skill.deleteSkill(skillName);
            WebElement toast = waitForToast();
            Assert.assertTrue(toast.getText().contains("Successfully Deleted"), "Skill not Deleted");
            System.out.println("SUCCESS: Deleted Skill: " + skillName);
        } catch (Exception e) {
            Assert.fail("Delete Skill failed: " + e.getMessage());
        }
    }

    @AfterClass
    public void logoutApp() {
        logout.logout();
    }

    @AfterTest
    public void tearDownTest() {
        tearDown();
    }
}
