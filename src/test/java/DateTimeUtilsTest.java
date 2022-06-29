import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTimeUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"2021-10-22 : 20211022"}, delimiter = ':')
    void parse(String resultDate, String date) {
        assertEquals(resultDate, DateTimeUtils.parse(date).toString());
    }

    @ParameterizedTest
    @CsvSource(value = {"2021-11-01 : 20211022 : 10",
            "2021-10-12 : 20211022 : -10"}, delimiter = ':')
    void plusDays(String resultDate, String date, int days) {
        assertEquals(resultDate, DateTimeUtils.plusDays(date, days).toString());
    }

    @ParameterizedTest
    @CsvSource(value = {"2021-09-22 : 20211022 : 30",
            "2021-11-01 : 20211022 : -10"}, delimiter = ':')
    void minusDays(String resultDate, String date, int days) {
        assertEquals(resultDate, DateTimeUtils.minusDays(date, days).toString());
    }

    @ParameterizedTest
    @CsvSource(value = {"30 : 20210922 : 20211022",
            "-10 : 20211022 : 20211012"}, delimiter = ':')
    void between(long days, String startDate, String endDate) {
        assertEquals(days, DateTimeUtils.between(startDate, endDate));
    }

}