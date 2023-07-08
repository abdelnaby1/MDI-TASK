package Tests;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;
import pages.Login;

public class LoginTests {
    private  SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    String email;
    @BeforeClass(description = "Setup Test Data.")
    public void beforeClass(){
        testData = new SHAFT.TestData.JSON("data.json");
        email = testData.getTestData("email");
    }

    @BeforeMethod(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();

    }
    @Epic("MDI")
    @Story("Amazon Basic Login")
    @Description("Given the user is not registered to amazon website, then the user cannot login.")
    @Test(description = "Check that the user cannot login with valid but not registered email.")
    public void checkTheUserCannotLoginWithNotRegisteredEmail() {
        new Home(driver).navigate()
                .openLoginPage().
                login(email)
                .checkTheAuthErrorMessageIsAppeared()
                .checkTheAuthErrorMessageDescriptionIsAppeared();
    }
    @AfterMethod(description = "Teardown Browser instance.")
    public void afterMethod() {
        driver.quit();
    }
}
