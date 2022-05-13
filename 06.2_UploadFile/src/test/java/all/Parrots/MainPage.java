package all.Parrots;

import all.base.basePage.Page;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {

    private String url = "https://lm.skillbox.cc/qa_tester/module08/homework1/";
    private JavascriptExecutor javascriptExecutor;

    @FindBy(id = "uploadInput")
    public WebElement uploadIcon;
    @FindBy(css = ".js-fileName img[src*='yes.png']")
    public WebElement okIcon;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void uploadFile(String file) {
        javascriptExecutor.executeScript("document.getElementById(\"uploadInput\").setAttribute(\"class\", \"bla-bla-bla\");");
        uploadIcon.sendKeys(file);
    }
}
