package all;
import all.Notes.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.stream.Collectors;

public class Tests extends TestBase {

    @Test
    public void noteMainPage__goToVkPage__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        //active
        var initialWindow = driver.getWindowHandle();
        page.addNote();
        page.vkLink.click();
        //assert
        var allWindows = driver.getWindowHandles();
        var expectedUrl = "https://vk.com/skillbox_education";
        var otherWindows = allWindows.stream().filter(i -> !i.equals(initialWindow)).collect(Collectors.toSet());
        //driver.switchTo().window(otherWindows.iterator().next());
        driver.switchTo().window(otherWindows.stream().findFirst().get());
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, allWindows.size(), "Открылось не два окна!"),
                () -> Assertions.assertEquals(expectedUrl, driver.getCurrentUrl(), "Не открылась выбранная страница!")
        );
    }
}
