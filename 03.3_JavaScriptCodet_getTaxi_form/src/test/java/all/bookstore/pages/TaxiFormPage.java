package all.bookstore.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaxiFormPage extends Page {

    private String url = "https://lm.skillbox.cc/qa_tester/module07/practice4/";
    private JavascriptExecutor javascriptExecutor;

    @FindBy(name = "time")
    public WebElement timeInput;
    @FindBy(css = ".form-submit")
    public WebElement submitButton;
    @FindBy(css = ".form-error")
    public WebElement errorMessage;

    private String cssDateLocator = "#date";

    public TaxiFormPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void addTime() {
        timeInput.sendKeys("01:30");
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public void setDate(String date) {
        javascriptExecutor.executeScript(String.format( "$( \"%s\" ).datepicker( \"setDate\", \"%s\" );", cssDateLocator, date));
    }

    public String getDate() {
        return String.valueOf(javascriptExecutor.executeScript(String.format("return $( \"%s\" ).datepicker( \"getDate\")", cssDateLocator)));
    }
}
