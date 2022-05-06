package all;

import all.bookshop.AllBooksPage;
import all.bookshop.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BookShopTest extends TestBase {

    @Test
    public void mainPage__goToAllBookPage__test() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        //actions
        page.navigationPanel.goToAllBooks();
        //assert
        var expectedUrl = new AllBooksPage(driver, wait).getPageUrl();
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl(), "Адрес страницы не совпадает с ожидаемым!");
    }

    private static Stream<Arguments> index_and_textItem() {
        return Stream.of(
                arguments( 0, "Все книги"),
                arguments( 1, "Новинки"),
                arguments( 2, "Бестселлеры"),
                arguments( 3, "Художественная литература"),
                arguments( 4, "Книги для детей"),
                arguments( 5, "Психология"),
                arguments( 6, "Фантастика"),
                arguments( 7, "Детективы")
        );
    }

    @ParameterizedTest
    @MethodSource("index_and_textItem")
    public void getText__selectBookMenu__test(int index, String value) {
        //arrange
        var expectedText = value;
        var page = new MainPage(driver, wait);
        page.open();
        //actions
        page.navigationPanel.moveToAllBooks();
        //assert
        var actualText = page.navigationPanel.getBooksButtonsListItem(index);
        Assertions.assertEquals(expectedText, actualText, "Заголовки не совпадают!");
    }
}
