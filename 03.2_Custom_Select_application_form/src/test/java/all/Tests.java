package all;
import all.bookstore.pages.FirstStepForm;
import all.bookstore.pages.ResultForm;
import all.bookstore.pages.SecondStepForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void first__customSelect_test() {
        var expectedDeliveryTime = "с 14 до 18";
        var firstPage = new FirstStepForm(driver, wait);
        var secondPage = new SecondStepForm(driver, wait);
        var resultForm = new ResultForm(driver, wait);
        firstPage.open();
        firstPage.pagination.goToSecondStep();
        secondPage.getDeliveryTime();
        secondPage.setDeliveryTime(expectedDeliveryTime);
        secondPage.submit();
        secondPage.submit.clickSubmit();
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedDeliveryTime, resultForm.getResultHeaderText(), "Время не соответствует выбранному, либо не отображается!"),
                () -> Assertions.assertNotEquals(secondPage.getDeliveryTime(), resultForm.getResultHeaderText(), "С момента открытия страницы не менялось время доставки!")
        );
    }

}
