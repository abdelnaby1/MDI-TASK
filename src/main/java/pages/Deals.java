package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Deals {
    private final SHAFT.GUI.WebDriver driver;
    private By categoryLoc(int categoryNumber){
        return By.xpath("(//h4[text()='Categories']/following::input)["+categoryNumber+"]");
    }
    private By productLoc(int productNumber){
        return By.xpath("(//div[contains(@data-testid,'deal-card')])["+productNumber+"]/a");
    }
    private By itemLoc(int itemNumber){
        return By.cssSelector("#octopus-dlp-asin-stream ul li:nth-child("+itemNumber+")");
    }

    public Deals(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("And when i select category number '{categoryNumber}'.")
    public Deals selectCategory(int categoryNumber){
        driver.element().click(categoryLoc(categoryNumber));
        return this;
    }
    @Step("And when i click on product number '{productNumber}'.")
    public Deals clickProduct(int productNumber){
        driver.element().click(productLoc(productNumber));
        return this;
    }
    @Step("And when i open item number '{itemNumber}' in this product.")
    public ProductDetails openItem(int itemNumber){
        driver.element().click(itemLoc(itemNumber));
        return new ProductDetails(driver);
    }
}
