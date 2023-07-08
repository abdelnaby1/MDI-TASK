package pages;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Home {
    private SHAFT.GUI.WebDriver driver;
    private String url = "https://www.amazon.eg/";
    private String title = "Your Souq is now Amazon.eg | Welcome to Amazon.eg in Egypt. Online Shopping for Electronics, Apparel, Beauty and Grooming, Grocery and more";
    private By loginLink = By.id("nav-link-accountList-nav-line-1");

    private By allTabLink = By.id("nav-hamburger-menu");
    private By todaysDealsLink =  By.xpath("//li//a[contains(text(),\"Today's Deals\")]");

    public Home(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    @Step("When I navigate to the Home page.")
    public Home navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("Then the browser title should be 'Google'.")
    public Home verifyBrowserTitleIsCorrect(){
        driver.verifyThat().browser().title().isEqualTo(title).perform();
        return this;
    }

    @Step("And I go to Login page")
    public Login openLoginPage(){
        driver.element().click(loginLink);
        return new Login(driver);
    }

    @Step("When i go to Today's Deal page")
    public Deals openTodaysDealPage(){
        driver.element().click(allTabLink).click(todaysDealsLink);
        return new Deals(driver);
    }
}
