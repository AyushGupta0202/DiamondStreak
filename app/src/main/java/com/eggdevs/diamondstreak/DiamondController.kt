package com.eggdevs.diamondstreak

import androidx.appcompat.app.AppCompatDelegate
import com.eggdevs.diamondstreak.models.local.CalendarMonthItem
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class DiamondController {
    companion object {

        lateinit var diamondApplication: DiamondApplication

        lateinit var diamondRealmDB: Realm

        fun initDiamond(application: DiamondApplication) {
            diamondApplication = application
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

//            val realmConfig = RealmConfiguration.create(schema = setOf(CalendarMonthItem::class))
//            diamondRealmDB = Realm.open(realmConfig)
        }
    }
}