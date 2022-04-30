package all.bookstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondStepForm extends Page {

    public Pagination pagination;
    public ContinuePopUp submit;

    @FindBy(css = "#next")
    public WebElement submitButton;
    @FindBy(tagName = "select")
    public WebElement selectTime;

    public SecondStepForm(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        pagination = new Pagination(driver, wait);
        submit = new ContinuePopUp(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void submit() {
        submitButton.click();
    }

    public void setDeliveryTime(String text) {
        new Select(selectTime).selectByVisibleText(text);
    }

    public String getDeliveryTime() {
        return new Select(selectTime).getFirstSelectedOption().getText();
    }
}
