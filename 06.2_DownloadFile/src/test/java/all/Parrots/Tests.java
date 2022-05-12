package all.Parrots;
import all.base.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void uploadPicture__success__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        //act
        var file = System.getProperty("user.dir") + "/file/butterfly_PNG1017.png";
        page.uploadFile(file);
        //assert
        Assertions.assertTrue(page.okIcon.isDisplayed(), "файл не загрузился!");
    }
}
