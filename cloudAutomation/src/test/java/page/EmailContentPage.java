package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.initialPages.CloudAbstractPage;

public class EmailContentPage extends CloudAbstractPage {

    private static final String XPATH_COST_IN_EMAIL_FIELD = "//h3[text() = 'Total Estimated Monthly Cost']/following::h3";
    private static final String ID_Iframe = "mess_frame";
    private static final Logger logger = LogManager.getRootLogger();

    public EmailContentPage(WebDriver driver) {
        super(driver);
        logger.info("EmailContentPage is open");
    }

    public String getTotalEstimateCost(){
       WebElement iFrame = waitForElementLocatedBy(driver, By.id(ID_Iframe));
       driver.switchTo().frame(iFrame);
       return waitForElementLocatedBy(driver, By.xpath(XPATH_COST_IN_EMAIL_FIELD)).getText();
    }
}
