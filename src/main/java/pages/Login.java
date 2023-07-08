package pages;

import com.mysql.cj.log.Log;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.python.antlr.ast.Str;

public class Login {
    private SHAFT.GUI.WebDriver driver;
    private By emailField = By.id("ap_email");
    private By coninuteBtn = By.cssSelector("input#continue");
    private By errorMsgTitle = By.xpath("//*[contains(@id,'auth-error-message-box')]//h4");
    private By errorMsDescription = By.xpath("//*[contains(@id,'auth-error-message-box')]//span");
    public Login(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("When the user fill his email and click continue.")
    public Login login(String email){
        driver.element().type(emailField,email)
                .click(coninuteBtn);
        return this;
    }
    @Step("Then the user should see error message 'There is a problem'.")
    public Login checkTheAuthErrorMessageIsAppeared(){
        driver.assertThat().element(errorMsgTitle).isVisible().perform();
        return this;
    }
    @Step("And sees the description of the error that no account with this email.")
    public Login checkTheAuthErrorMessageDescriptionIsAppeared(){
        driver.assertThat().element(errorMsDescription).isVisible().perform();
        return this;
    }
//    public String getErrorMsgTitle(){
//        return driver.element().getText(errorMsgTitle);
//    }
//    public String getErrorMsgDescription(){
//        return driver.element().getText(errorMsDescription);
//    }
}
