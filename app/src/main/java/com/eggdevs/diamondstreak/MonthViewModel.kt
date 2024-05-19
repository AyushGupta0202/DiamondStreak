package com.eggdevs.diamondstreak

import androidx.lifecycle.ViewModel
import com.eggdevs.diamondstreak.models.local.CalendarMonthItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class MonthViewModel : ViewModel() {
    fun getMonthDaysList(monthInt: Int, yearInt: Int): Flow<List<CalendarMonthItem>> = flow {
        val weekDays = DiamondUtils.getDaysOfWeek()
        val monthDays: MutableList<CalendarMonthItem> = mutableListOf()
        monthDays.addAll(weekDays)
        val thisDate = Date(yearInt - EPOCH_YEAR, monthInt, 1)
        val calendar = Calendar.getInstance()
        calendar.time = thisDate
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1
        for (i in 1..dayOfWeek) {
            monthDays.add(CalendarMonthItem(
                0, 0, yearInt, WEEK_DAYS[i], false, MONTHS[monthInt], "", " ", false
            ))
        }
        val daysInMonth = DiamondUtils.getDaysInMonth(yearInt, monthInt + 1)
        for (i in 1..daysInMonth) {
            monthDays.add(CalendarMonthItem(
                0, i, yearInt, WEEK_DAYS[(i - 1) % WEEK_DAYS_COUNT], true, MONTHS[monthInt], "", "$i", false,
                Date(yearInt - EPOCH_YEAR, monthInt, i)
            ))
        }
        emit(monthDays)
    }
}