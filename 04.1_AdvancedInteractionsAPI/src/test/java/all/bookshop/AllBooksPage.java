package all.bookshop;
import all.basePage.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllBooksPage extends Page{

    public AllBooksPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "pages/all_books.html");
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
}

