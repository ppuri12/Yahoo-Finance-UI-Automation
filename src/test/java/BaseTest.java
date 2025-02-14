import org.example.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void createDriver(ITestContext context) {
        webDriverThreadLocal.set(WebDriverManager.createDriverInstance());
    }

    public WebDriver getWebDriver() {
        return webDriverThreadLocal.get();
    }

    @AfterMethod
    public void quitDriver() {
        webDriverThreadLocal.get().quit();
    }
}
