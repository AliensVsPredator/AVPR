package org.avpr.common.api.common;

import java.time.LocalDate;
import java.time.Month;

/**
 * The DateUtil class provides utility methods for working with dates.
 */
public class DateUtil {

    /**
     * Checks if the current date is Halloween.
     *
     * @return true if the current date is October 31st, false otherwise
     */
    public static boolean isHalloween() {
        LocalDate now = LocalDate.now();
        return now.getMonth() == Month.OCTOBER && now.getDayOfMonth() == 31;
    }
}
