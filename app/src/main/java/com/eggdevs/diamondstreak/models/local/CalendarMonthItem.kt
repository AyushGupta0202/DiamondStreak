package com.eggdevs.diamondstreak.models.local

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.util.*

data class CalendarMonthItem(
//    @PrimaryKey
    val id: Int,
    var dayOfTheMonth: Int,
    var yearOfTheItem: Int,
    var dayOfTheWeek: String,
    var isClickable: Boolean = true,
    var monthOfTheItem: String,
    var date: String,
    var visibleText: String,
    var isMarked: Boolean = false,
    var dateObject: Date? = null
)/*: RealmObject*/
