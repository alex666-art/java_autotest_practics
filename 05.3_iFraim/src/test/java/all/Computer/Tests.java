package all.Computer;
import all.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void mainPage__sendEmail__success__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        //active
        page.switchToFrame();
        var email = "test@skillbox.com";
        page.emailInput.sendKeys(email);
        page.mainButton.click();
        //assert
        Assertions.assertEquals(email, page.emailResult.getText(), "Email не соответствует введённому!");
    }

    @Test
    public void mainPage__sendEmail__headerIsVisible__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        //active
        page.switchToFrame();
        var email = "test@skillbox.com";
        page.emailInput.sendKeys(email);
        page.mainButton.click();
        page.switchToMainPage();
        //assert
        Assertions.assertTrue(page.header.isDisplayed(), "Заголовок не отображается!");
    }

    @Test
    public void mainPage__clickOnSkillboxLink__wasOpenedNewWindow__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        //active
        page.switchToFrame();
        page.switchToFrame();
        page.footerSkillboxLink.click();
        //assert
        Assertions.assertEquals(2, getAllWindows().size(), "Не открылось новое окно!");
    }

    @Test
    public void mainPage__clickOnSkillboxLink__emailFieldIsDisplayed__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        //active
        page.switchToFrame();
        page.switchToFrame();
        page.footerSkillboxLink.click();
        page.switchToParrentFrame();
        //assert
        Assertions.assertTrue(page.emailInput.isDisplayed(), "Не отображается поле для ввода email!");
    }


}
