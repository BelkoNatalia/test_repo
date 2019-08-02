package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.initialPages.CloudHomePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FindInitialBtnTest extends CommonConditions{
    @Test(description = "Find initial button")
    public void FindInitialBtn () {
        System.out.println("*****");
//        Assert.fail();
        String expectedlBtnName = "See products";
        CloudHomePage cloudHomePage = new CloudHomePage(driver);

        String currentBtnName = cloudHomePage.openPage()
                .seeAllProductsBtnName();
//        Assert.assertEquals(currentBtnName, expectedlBtnName);
        assertThat(currentBtnName, is(equalTo(expectedlBtnName)));
    }
}
