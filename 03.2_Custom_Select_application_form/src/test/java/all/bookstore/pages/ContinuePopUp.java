package all.bookstore.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContinuePopUp extends Page{

    @FindBy(css = "#ok")
    public WebElement submitButton;

    public ContinuePopUp(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void clickSubmit() {
        submitButton.click();
    }
}
