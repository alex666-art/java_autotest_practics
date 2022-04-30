package all;

import all.bookstore.pages.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Tests extends TestBase {

    private static Stream<Arguments> years_list() {
        return Stream.of(
                arguments("2017"),
                arguments("2018"),
                arguments("2019"),
                arguments("2020")
        );
    }

    @ParameterizedTest
    @MethodSource("years_list")
    public void searchPage_SelectYear_Success(String expectedYear) {
        //arrange
        var page = new SearchPage(driver, wait);
        page.open();
        var initialYear = page.getYear();
        //actions
        page.setYear(expectedYear);
        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedYear, page.getYear(), "Выбран не верный год!"),
                () -> Assertions.assertNotEquals(initialYear, page.getYear(), "С момента открытия страницы, год не изменился!")
        );
    }

    @Test
    public void searchPage_SelectAuthor_CorrectList() {
        //arrange
        var page = new SearchPage(driver, wait);
        page.open();
        //assert
        var expectedAuthors = Arrays.asList("Рэнд А.",
                "Те Нэм Джу",
                "Уайт К.",
                "Лабковский М.",
                "Disney",
                "Хара Д.",
                "Мэнсон М.",
                "Синсеро Дж.",
                "Янссон Т.",
                "Руни С.",
                "Оруэлл Дж.",
                "Петросян М.",
                "Коэльо П.",
                "Сапковский А.",
                "Брэдбери Р.");

        Assertions.assertEquals(expectedAuthors, page.getAuthors(), "В списке присутствуют не все авторы!");
    }

    private static Stream<Arguments> search_scenario() {
        return Stream.of(
                arguments("Янссон Т.", "2017")
        );
    }

    @ParameterizedTest
    @MethodSource("search_scenario")
    public void searchPage_AddSearch(String author, String date) {
        //arrange
        var page = new SearchPage(driver, wait);
        page.open();
        //actions
        page.setAuthor(author);
        page.setYear(date);
        page.addBookName();
        page.addBookPrice();
        page.searchButton.click();
        //assert
        Assertions.assertTrue(page.getSearchResult(), "Поиск не работает!");
    }
}
