package common.util;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * 日期工具类
 */
public class DateUtils {

    public static final String COMMON_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter COMMON_FORMAT_FORMATTER = DateTimeFormatter.ofPattern(COMMON_FORMAT);

    /**
     * 格式化毫秒时间戳
     */
    public static String format(long millis) {
        return COMMON_FORMAT_FORMATTER.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.of("Asia/Shanghai")));
    }

}
