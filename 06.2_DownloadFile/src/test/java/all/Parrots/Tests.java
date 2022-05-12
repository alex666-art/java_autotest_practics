package all.Parrots;
import all.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void mainPage__changeEmailInAlertForm__test() {
        //arrange
        var page = new  MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        //act
        page.emailInput.sendKeys("test@skillbox.ru");
        page.submitButton.click();
        page.anotherEmailButton.click();
        var newEmail= "new@skillbox.ru";
        var alert =  driver.switchTo().alert();
        alert.sendKeys(newEmail);
        alert.accept();
        //assert
        var newAlert = driver.switchTo().alert();
        var expectedText = "E-mail успешно изменён на " + newEmail;
        var actualText = newAlert.getText();
        Assertions.assertEquals(expectedText, actualText, "Не отображается новый email!");
    }
}
