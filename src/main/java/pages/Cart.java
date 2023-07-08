package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Cart {
    private final SHAFT.GUI.WebDriver driver;
    private By productPriceLoc = By.className("sc-product-price");
    private By subtotalLoc = By.cssSelector("#sc-subtotal-amount-activecart span");
    private By qtyLoc = By.id("quantity");
    private By productName = By.xpath("//span[contains(@class,'sc-grid-item-product-title')]//span[1]");

    public Cart(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("Then the product price should be displayed .")
    public String getProductPrice(){
       return driver.element().getText(productPriceLoc).substring(4);
    }
    @Step("Then the subtotal should be displayed and should be correct.")
    public String getSubtotal(){
        return driver.element().getText(subtotalLoc).substring(4);
    }
    @Step("Then the chosen quantity should be displayed.")
    public String getQty(){
        return driver.element().getSelectedText(qtyLoc);
    }
    @Step("Then the product name should be displayed and the same in product details.")
    public String getProductName(){
        return driver.element().getText(productName);
    }


}
