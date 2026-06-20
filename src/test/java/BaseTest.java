import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import util.Constants;
import util.DriverFactory;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() throws IOException {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.driverInit();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
