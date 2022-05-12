package all.Parrots;
import all.basePage.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MainPage extends Page {

    private String url = "http://qajava.skillbox.ru/module5";

    @FindBy(tagName = "iframe")
    public WebElement iframeElement;
    @FindBy(css = ".email")
    public WebElement emailInput;
    @FindBy(id = "write-to-me")
    public WebElement submitButton;
    @FindBy(name = "result-email")
    public WebElement resultTitle;
    @FindBy(id = "anotherEmail")
    public WebElement anotherEmailButton;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void switchToFrame() {
        driver.switchTo().frame(iframeElement);
    }
}
