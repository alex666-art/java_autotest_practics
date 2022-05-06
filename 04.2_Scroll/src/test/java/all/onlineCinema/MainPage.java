package all.onlineCinema;

import all.basePage.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {

    private String url = "http://qa.skillbox.ru/module19/#";
    private JavascriptExecutor javascriptExecutor;

    @FindBy(className = "contact-form")
    public WebElement helloForm;
    @FindBy(tagName = "html")
    public WebElement bodyPage;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void scrollToHelloForm() {
        //способ первый
       /* new Actions(driver)
                .moveToElement(helloForm)
               .perform();*/

        //способ второй
        /*for (int i = 0; i < 140; i++) {
            bodyPage.sendKeys(Keys.ARROW_DOWN);
        }*/

        //третий способ
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", helloForm);
        wait.until(ExpectedConditions.visibilityOf(helloForm));
    }
}
