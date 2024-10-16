package org.avpr.common.api.common;

import java.time.LocalDate;
import java.time.Month;

public class DateUtil {

    public static boolean isHalloween() {
        LocalDate now = LocalDate.now();
        return now.getMonth() == Month.OCTOBER && now.getDayOfMonth() == 31;
    }
}
