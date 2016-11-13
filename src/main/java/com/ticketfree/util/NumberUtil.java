package com.ticketfree.util;

public class NumberUtil {

    public static boolean isNumber(final Integer val) {
        return !(null == val || val == -1);
    }
}
