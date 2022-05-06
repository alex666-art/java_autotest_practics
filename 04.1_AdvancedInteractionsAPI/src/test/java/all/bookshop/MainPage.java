package all.bookshop;
import all.basePage.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {

    public NavigationPanel navigationPanel;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "index.html");
        this.driver = driver;
        this.wait = wait;
        this.navigationPanel = new NavigationPanel(driver, wait);
        PageFactory.initElements(driver, this);
    }
}

