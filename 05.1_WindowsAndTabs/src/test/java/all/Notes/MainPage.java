package all.Notes;
import all.basePage.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {

    @FindBy(css = ".popup__wrapper")
    public WebElement popUp;
    @FindBy(css = ".popup__baseInput > .baseInput__field")
    public WebElement titleInput;
    @FindBy(css = ".popup__textarea .baseTextarea__text")
    public WebElement textInput;
    @FindBy(css = ".popup__baseButton")
    public WebElement addNoteButton;
    @FindBy(css = ".baseButtonAdd__text")
    public WebElement addButton;
    @FindBy(css = ".socialLinks__link:nth-of-type(2)")
    public WebElement vkLink;

    private String url = "http://qa.skillbox.ru/module15/bignotes/#/";

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void addNote() {
            addButton.click();
            wait.until(ExpectedConditions.visibilityOf(popUp));
            titleInput.sendKeys("Заметка");
            textInput.sendKeys("Тестовый текст заметки");
            addNoteButton.click();
    }
}
