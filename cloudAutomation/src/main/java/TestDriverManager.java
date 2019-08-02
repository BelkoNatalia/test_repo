//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestDriverManager {
    private static WebDriver driver;

    public static void main(String[] args) {
       // WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
}
