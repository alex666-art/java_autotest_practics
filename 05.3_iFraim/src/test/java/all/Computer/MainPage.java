package all.Computer;
import all.basePage.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MainPage extends Page {

    @FindBy(tagName = "iframe")
    public WebElement iframeElement;
    @FindBy(css = "input.email")
    public WebElement emailInput;
    @FindBy(id = "write-to-me")
    public WebElement mainButton;
    @FindBy(css = "pre[name='result-email']")
    public WebElement emailResult;
    @FindBy(className = "header")
    public WebElement header;
    @FindBy(css = "a.footer__contactItem.descriptionText")
    public WebElement footerSkillboxLink;

    private String url = "";

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

    public void switchToMainPage() {
        driver.switchTo().defaultContent();
    }

    public void switchToParrentFrame() {
        driver.switchTo().parentFrame();
    }
}
