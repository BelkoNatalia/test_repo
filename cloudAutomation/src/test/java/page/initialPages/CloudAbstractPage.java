package page.initialPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public abstract class CloudAbstractPage {
    protected WebDriver driver;
    private static final int TIME_WAIT = 20;
    private static final String SCRIPT_TEMPLATE = "window.open('%s')";

    public CloudAbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, TIME_WAIT)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected WebElement waitForElementToBeClickableBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, TIME_WAIT)
                .until(ExpectedConditions.elementToBeClickable(by));
    }


    protected void waitInvisibilityOfElementLocated(WebDriver driver, By by) {
        new WebDriverWait(driver,TIME_WAIT).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void openNewTabWithUrl(String url) {
        String script = String.format(SCRIPT_TEMPLATE, url);
        ((JavascriptExecutor) driver).executeScript(script);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void goToTabByWindowHandle(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public String getCurrentWindowHandle(){
        return driver.getWindowHandle();
    }
}
