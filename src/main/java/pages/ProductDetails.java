package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductDetails {
    private final SHAFT.GUI.WebDriver driver;
    private By sizeField =By.id("native_dropdown_selected_size_name");
    private By regularPriceField = By.id("newAccordionRow_1");
    private By qtyField = By.id("quantity");
    private By addToCartBtn = By.id("add-to-cart-button");
    private By unavailable = By.xpath("//span[contains(text(),'Currently unavailable.')]");
    private By addedToCartLoc = By.xpath("//span[contains(text(),' Added to Cart')]");
//    private By productNameLoc = By.id("productTitle");

    private By productNameLoc = By.id("productDescription");

    private By productPriceLoc = By.cssSelector(".a-price.apexPriceToPay");
    public ProductDetails(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("And i select a size.")
    public ProductDetails selectSize(){
        Select select = new Select(driver.getDriver().findElement(sizeField));
        List<WebElement> options = select.getOptions();
        int index = options.size() - 1;
        driver.element().select(sizeField,options.get(index).getText());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int count = driver.getDriver().findElements(unavailable).size();
        while (count > 0 && index >=0){
            index--;
            driver.element().select(sizeField,options.get(index).getText());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count = driver.getDriver().findElements(unavailable).size();

        }
        return this;
    }
    @Step("And i select a regular price.")
    public ProductDetails selectRegularPrice(){
        driver.element().click(regularPriceField);
        return this;
    }
    @Step("And i select a qty.")
    public ProductDetails selectQty(int qty){
        driver.element().select(qtyField, String.valueOf(qty));
        return this;
    }
    @Step("And i click on add to cart.")
    public ProductDetails addToCart(){
        driver.element().click(addToCartBtn);
       return this;
    }
    @Step("Then the items are added to the cart.")
    public ProductDetails verifyItemsAreAddedToCart(){
        driver.assertThat().element(addedToCartLoc).exists().perform();
        return this;
    }
    public ArrayList getProductInfo(){
        String name = driver.element().getText(productNameLoc);
        String price = driver.element().getText(productPriceLoc);
        ArrayList<String> productInfo = new ArrayList<String>();
        productInfo.add(name.substring(0,20));
        productInfo.add(price.substring(3));
        return productInfo;
    }
}
