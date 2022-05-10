package all;
import all.Notes.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void noteMainPage__goToVkPage__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        //active
        page.addNote();
        page.vkLink.click();
        //assert
        var expectedUrl = "https://vk.com/skillbox_education";
        switchToFirstWindow();
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, getAllWindows().size(), "Открылось не два окна!"),
                () -> Assertions.assertEquals(expectedUrl, driver.getCurrentUrl(), "Не открылась выбранная страница!")
        );
    }

    @Test
    public void noteMainPage__goToVkPage__andClose__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.addNote();
        page.vkLink.click();
        switchToFirstWindow();
        //active
        driver.close();
        switchToWindow(initialWindow);
        //assert
        var expectedUrl = page.getPageUrl();
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, getAllWindows().size(), "Открылось более одного окна!"),
                () -> Assertions.assertEquals(expectedUrl, driver.getCurrentUrl(), "Изменился адрес начальной страницы")
        );
    }
}
