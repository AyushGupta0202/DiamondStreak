package com.eggdevs.diamondstreak

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class DiamondApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        DiamondController.initDiamond(this)
    }
}