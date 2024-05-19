package com.eggdevs.diamondstreak

import com.eggdevs.diamondstreak.models.local.CalendarMonthItem
import java.time.YearMonth

class DiamondUtils {

    companion object {
        fun getYearSelectedFromPosition(position: Int): Int = BASE_YEAR + position / 12

        fun getMonthSelectedFromPosition(position: Int): Int = position % 12

        fun getDaysOfWeek() = listOf(
            CalendarMonthItem(1,0, 0, "Sunday", false, "", "", "S"),
            CalendarMonthItem(2, 0, 0, "Monday", false, "", "", "M"),
            CalendarMonthItem(3, 0, 0, "Tuesday", false, "", "", "T"),
            CalendarMonthItem(4, 0, 0, "Wednesday", false, "", "", "W"),
            CalendarMonthItem(5, 0, 0, "Thursday", false, "", "", "T"),
            CalendarMonthItem(6, 0, 0, "Friday", false, "", "", "F"),
            CalendarMonthItem(7, 0, 0, "Saturday", false, "", "", "S"),
        )

        fun getDaysInMonth(year: Int, month: Int): Int {
            return YearMonth.of(year, month).lengthOfMonth()
        }
    }
}