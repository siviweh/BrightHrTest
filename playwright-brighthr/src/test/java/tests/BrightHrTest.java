package tests;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.EmployeePage;
import pages.LoginPage;

import java.nio.file.Paths;

public class BrightHrTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private LoginPage loginPage;
    private EmployeePage employeePage;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();

        // ✅ Launch browser using system-installed Chrome
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setExecutablePath(Paths.get("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"))
                .setHeadless(false)
        );

        page = browser.newPage();
        loginPage = new LoginPage(page);
        employeePage = new EmployeePage(page);
    }

    @Test(priority = 1)
    public void testLogin() {
        loginPage.login("qaAutomationTechTask@grr.la", "A1234567890-");
    }

    @Test(priority = 2)
    public void testAddEmployees() {
        employeePage.goToEmployeeTab();
        employeePage.addEmployee("Alice", "Smith", "alice.smith@example.com", "1234567890");
        employeePage.addEmployee("Bob", "Johnson", "bob.johnson@example.com", "0987654321");
    }

    @Test(priority = 3)
    public void testVerifyEmployees() {
        employeePage.goToEmployeeTab();
        Assert.assertTrue(employeePage.verifyEmployeeExists("Alice Smith"));
        Assert.assertTrue(employeePage.verifyEmployeeExists("Bob Johnson"));
    }

    @AfterClass
    public void tearDown() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
