package all;
import all.bookstore.pages.TaxiFormPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void add_date_JS_test() {
        var page = new TaxiFormPage(driver, wait);
        page.open();
        var initialDate = page.getDate();

        page.setDate("02/05/2022");
        page.addTime();
        page.submitButton.click();

        var expectedErrorMessage = "Извините, в связи с техническими работами невозможно сделать заказ";
        Assertions.assertAll(
                () -> Assertions.assertTrue(page.errorMessage.isDisplayed(), "Не отобразилось сообщение об ошибке!"),
                () -> Assertions.assertEquals(expectedErrorMessage, page.getErrorMessageText(), "Неверное сообщение об ошибке!"),
                () -> Assertions.assertNotEquals(initialDate,page.getDate(), "Дата не изменилась!")
        );
    }
}
