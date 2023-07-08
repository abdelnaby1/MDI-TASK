package Tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;
import pages.Navbar;

public class AuthorizationTests {
    private  SHAFT.GUI.WebDriver driver;

    @BeforeMethod(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        new Home(driver).navigate();

    }
    @Epic("MDI")
    @Story("Amazon Authorizations")
    @Description("Given the user is not logged in to amazon website, then the user cannot see orders.")
    @Test(description = "Check that the user cannot see orders.")
    public void checkThatUserCannotSeeOrders() {
        new Navbar(driver).goToYourOrders()
                .verifyUserCannotSeeOrders();

    }
    @Epic("MDI")
    @Story("Amazon Authorizations")
    @Description("Given the user is not logged in to amazon website, then the user cannot see addresses.")
    @Test(description = "Check that the user cannot see addresses.")
    public void checkThatUserCannotSeeAddresses() {
        new Navbar(driver).goToYourAddresses()
                .verifyUserCannotSeeAddresses();

    }
    @Epic("MDI")
    @Story("Amazon Authorizations")
    @Description("Given the user is not logged in to amazon website, then the user can see lists.")
    @Test(description = "Check that the user can see lists.")
    public void checkThatUserCanSeeLists() {
        new Navbar(driver).changLang().goToYourLists()
                .verifyUserCanSeeLists();

    }
    @AfterMethod(description = "Teardown Browser instance.")
    public void afterMethod() {
        driver.quit();
    }
}
