package all.bookstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstStepForm extends Page{

    private String url = "https://lm.skillbox.cc/qa_tester/module07/homework1/";

    public  Pagination pagination;

    public FirstStepForm(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        pagination = new Pagination(driver,wait);
    }

    public void open() {
        driver.navigate().to(url);
    }
}
