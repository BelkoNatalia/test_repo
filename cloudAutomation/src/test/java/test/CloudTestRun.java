package test;

import model.ComputerEngine;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CloudCalkulationResultPage;
import page.initialPages.CloudHomePage;
import page.CrazyMailingPage;
import page.EmailYourEstimatePage;
import service.ProductCreator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CloudTestRun extends CommonConditions {

    @Test(description = "Filling form correct amount of the order by email")
    public void checkTheCorrectAmountOfTheOrderByEmail() {
//        Assert.fail("[Natasha] Filling form correct amount of the order by email");
        String emailSubject = "Google Cloud Platform Price Estimate";
        String temporaryMail = "https://www.crazymailing.com";

        ComputerEngine testComputerEngine = ProductCreator.createProductComputerEngine();

        CloudHomePage cloudHomePage = new CloudHomePage(driver);

        cloudHomePage.openPage()
                .seeAllProducts()
                .seePricing()
                .usePricingCalculator()
                .activateComputeEngine()
                .fillNumberOfInstances(testComputerEngine)
                .chooseOperatingSystem(testComputerEngine)
                .chooseMachineClass(testComputerEngine)
                .chooseMachineType(testComputerEngine)
                .pickGPUs()
                .chooseNumberOfGPUs(testComputerEngine)
                .chooseGPuType(testComputerEngine)
                .chooseLocalSsd(testComputerEngine)
                .chooseDatacenterLocation(testComputerEngine)
                .chooseCommittedUsage(testComputerEngine)
                .getEstimation();

        CloudCalkulationResultPage cloudCalkulationResultPage = new CloudCalkulationResultPage(driver);

        String estimatedCostByPage = cloudCalkulationResultPage.getTotalEstimatedCost();

        EmailYourEstimatePage emailYourEstimatePage = cloudCalkulationResultPage.chooseEmailEstimate();

        String emailEstimateWindowHandle = emailYourEstimatePage.getCurrentWindowHandle();
        emailYourEstimatePage.openNewTabWithUrl(temporaryMail);

        CrazyMailingPage crazyMailingPage = new CrazyMailingPage(driver);
        String emailAddress = crazyMailingPage.getEmail();
        String crazyMailingWindowHandle = crazyMailingPage.getCurrentWindowHandle();
        crazyMailingPage.goToTabByWindowHandle(emailEstimateWindowHandle);

        new EmailYourEstimatePage(driver).fillEmailField(emailAddress)
                .sendEmail()
                .goToTabByWindowHandle(crazyMailingWindowHandle);

        String totalEstimateCostFromEmail = crazyMailingPage.openEmailBySubject(emailSubject)
                .getTotalEstimateCost().trim();

        String[] estimatedCostArray = estimatedCostByPage.split(":");
        String expectedEstimatedCostValue = estimatedCostArray[1].replaceAll("per 1 month", "").trim();

//        Assert.assertEquals(expectedEstimatedCostValue, totalEstimateCostFromEmail);
        assertThat(expectedEstimatedCostValue, is(equalTo(totalEstimateCostFromEmail)));


    }

}
