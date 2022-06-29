import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     *
     * @param date 日期格式，String - "yyyyMMdd"
     * @return LocalDate
     */
    public static LocalDate parse(String date) {
        return LocalDate.parse(date, dateFormatter);
    }

    /**
     * 輸入日期、和天數，回傳那天過後的日期
     * @param date 日期格式，String - "yyyyMMdd"
     * @param days 增加天數
     * @return LocalDate
     */
    public static LocalDate plusDays(String date, int days) {
        return LocalDate.parse(date, dateFormatter)
                .plusDays(days);
    }

    /**
     * 輸入日期、和天數，回傳那天以前的日期
     * @param date 日期格式，String - "yyyyMMdd"
     * @param days 回扣天數
     * @return LocalDate
     */
    public static LocalDate minusDays(String date, int days) {
        return LocalDate.parse(date, dateFormatter)
                .minusDays(days);
    }

    /**
     * 輸入起始日期、和結束日期，回傳相差的天數
     * @param startDate 起始日期：格式 - String - "yyyyMMdd"
     * @param endDate 結束日期：格式 - String - "yyyyMMdd"
     * @return 相差的天數
     */
    public static long between(String startDate, String endDate) {
        LocalDateTime startTime = LocalDate.parse(startDate, dateFormatter).atStartOfDay();
        LocalDateTime endTime = LocalDate.parse(endDate, dateFormatter).atStartOfDay();
        return Duration.between(startTime, endTime)
                .toDays();
    }

}
