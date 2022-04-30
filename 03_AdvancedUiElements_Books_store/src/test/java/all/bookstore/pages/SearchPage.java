package all.bookstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends Page {
    private String url = "http://qajava.skillbox.ru/search.html";

    @FindBy(name = "year")
    public WebElement dateSelect;
    @FindBy(name = "author")
    public WebElement authorSelect;
    @FindBy(name = "fname")
    public WebElement bookNameInput;
    @FindBy(name = "scost")
    public WebElement bookPriceInput;
    @FindBy(css = ".show-results")
    public WebElement searchButton;
    @FindBy(css = ".book-info")
    public List<WebElement> cards;

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }

    public void setYear(String value) {
        var year = new Select(dateSelect);
        year.selectByValue(value);
    }

    public void setAuthor(String value) {
        var author = new Select(authorSelect);
        author.selectByValue(value);
    }

    public String getYear() {
        var year = new Select(dateSelect);
        return year.getFirstSelectedOption().getText();
    }

    public List<String> getAuthors() {
        var author = new Select(authorSelect);
        return author.getOptions().stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public void addBookName() {
        bookNameInput.sendKeys("Все о муми-троллях.");
    }

    public void addBookPrice() {
        bookPriceInput.sendKeys("555");
    }

    public Boolean getSearchResult() {
      if(wait.until(driver -> !(cards.size() == 1))) {
          return false;
      } else return true;
    }
}
