package all;

import all.onlineCinema.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase{

    @Test
    public void scrollToHelloForm__and__visibleElement__test__success() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        //active
        page.scrollToHelloForm();
        //assert
        Assertions.assertTrue(page.helloForm.getAttribute("class").contains("animated"), "Форма не отображается!");
    }
}
