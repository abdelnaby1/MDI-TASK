package Tests;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.ReportManager;
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.*;
import pages.Home;
import pages.Navbar;
import pages.ProductDetails;

public class CartTests {
    private  SHAFT.GUI.WebDriver driver;
    private Home home;
    int qty = 2;
    String name;
    Double price;
    String subtotal;
    private SHAFT.TestData.JSON testData;
    @BeforeClass(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        home = new Home(driver).navigate();
        new Navbar(driver).changLang();
    }
    @Epic("MDI")
    @Story("Amazon Add to cart")
    @Description("Given the user add items to the cart, then the user can see these items on the cart page.")
    @Test(description = "Check that the user can add items to cart successfully.")
    public void checkItemsAddedToCart() {

        var productInfo =
                home.openTodaysDealPage()
                .selectCategory(2)
                .clickProduct(1)
                .openItem(2)
                        .getProductInfo();

        new ProductDetails(driver)
                .selectSize()
                .selectRegularPrice()
                .selectQty(2)
                .addToCart()
                .verifyItemsAreAddedToCart();

        name = ((String) productInfo.get(0)).toLowerCase().substring(0,20);
        price = Double.parseDouble((String) productInfo.get(1));



    }
    @Epic("MDI")
    @Story("Amazon Add to cart")
    @Description("Given the user add items to the cart, then the user can see these items on the cart page.")
    @Test(description = "Check that the user can add items to cart successfully.",dependsOnMethods = "checkItemsAddedToCart")
    public void  checkTheItemsExistedOnTheCart() {
        var carPage = new Navbar(driver).openCartPage();
        double productPriceInCart = Double.parseDouble(carPage.getProductPrice());
        double subtotal = Double.parseDouble(carPage.getSubtotal());
        int qtyInCart = Integer.parseInt(carPage.getQty());
        String productNameInCart = carPage.getProductName().toLowerCase();

        Validations.assertThat()
                .number((Number) productPriceInCart)
                .isEqualTo(price)
                .perform();

        Validations.assertThat()
                .number((Number) subtotal)
                .isEqualTo(price * qty)
                .perform();
        Validations.assertThat()
                .number((Number) qtyInCart)
                .isEqualTo(qty)
                .perform();
        Validations.verifyThat()
                .object(productNameInCart)
                .contains(name)
                .perform();

    }
    @AfterClass(description = "Teardown Browser instance.")
    public void afterMethod() {
        driver.quit();
    }
}
