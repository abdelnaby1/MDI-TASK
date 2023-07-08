package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Navbar {
    private final SHAFT.GUI.WebDriver driver;
    private By cartLink = By.id("nav-cart-count-container");
    private By lang = By.cssSelector("#nav-tools .icp-nav-link-inner");
    private By enLangLink = By.cssSelector("a[href='#switch-lang=en_AE']");
    private By accountLink = By.id("nav-link-accountList");
    private By yourOrdersLink = By.id("nav_prefetch_yourorders");
    private By yourAddressesLink = By.id("nav_prefetch_youraddresses");
    private By yourListsLink = By.xpath("//a[contains(text(),'Your Lists')]");
    public Navbar(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("And the user change lang.")
    public Navbar changLang(){
        driver.element().hover(lang).click(enLangLink);
        return this;
    }
    @Step("And the user go to the cart.")
    public Cart openCartPage(){
        driver.element().click(cartLink);
        return new Cart(driver);
    }
    @Step("And the user go to orders.")
    public Navbar goToYourOrders(){
        driver.element().hover(accountLink).click(yourOrdersLink);
       return this;
    }
    @Step("Then the user cannot see orders until he logins")
    public Navbar verifyUserCannotSeeOrders(){
        driver.verifyThat().browser().url().contains("signin").perform();
        return this;
    }
    @Step("And the user go to addresses.")
    public Navbar goToYourAddresses(){
        driver.element().hover(accountLink).click(yourAddressesLink);
        return this;
    }
    @Step("Then the user cannot see addresses until he logins")
    public Navbar verifyUserCannotSeeAddresses(){
        driver.verifyThat().browser().url().contains("signin").perform();
        return this;
    }
    @Step("And the user go to lists.")
    public Navbar goToYourLists(){
        driver.element().click(yourListsLink);
        return this;
    }
    @Step("Then the user navigate to lists page and can see his lists")
    public Navbar verifyUserCanSeeLists(){
        driver.verifyThat().browser().url().contains("wishlist").perform();
        return this;
    }


}
