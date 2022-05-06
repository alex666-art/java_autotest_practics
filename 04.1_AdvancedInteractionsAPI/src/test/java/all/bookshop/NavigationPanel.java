package all.bookshop;

import all.basePage.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NavigationPanel extends Page {

    @FindBy(css = "#genres")
    public WebElement bookButton;
    @FindBy(css = ".genres-menu-item-first")
    public WebElement allBooksButton;
    @FindBy(css = ".genres-menu-item")
    public List<WebElement> booksButtonsList;

    public NavigationPanel(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void goToAllBooks() {
        new Actions(driver)
                .moveToElement(bookButton)
                .perform();
        wait.until(ExpectedConditions.visibilityOf(allBooksButton));
        allBooksButton.click();

    }

    public void moveToAllBooks() {
        new Actions(driver)
                .moveToElement(bookButton)
                .perform();
    }

    public String getBooksButtonsListItem(int index) {
        return booksButtonsList.get(index).getText();
    }
}

