package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.initialPages.CloudAbstractPage;

public class CrazyMailingPage extends CloudAbstractPage {

    private static final String ID_TEMPORARY_EMAIL_FIELD = "email_addr";
    private static final String TEMPLATE_XPATH_SUBJECT_CLOUD_EMAIL = "//strong[contains(text(),'%s')]";
    private static final Logger logger = LogManager.getRootLogger();

    public CrazyMailingPage(WebDriver driver) {
        super(driver);
        logger.info("CrazyMailingPage is open");
    }
    public String getEmail(){
        WebElement email = waitForElementLocatedBy(driver, By.id(ID_TEMPORARY_EMAIL_FIELD));
        return email.getText();
    }

    public EmailContentPage openEmailBySubject(String emailSubject){
        String xpathSubject = String.format(TEMPLATE_XPATH_SUBJECT_CLOUD_EMAIL, emailSubject);
        waitForElementToBeClickableBy(driver, By.xpath(xpathSubject)).click();
        logger.info("Arrived email by subject" + emailSubject + " is open");
        return new EmailContentPage(driver);
    }
}
