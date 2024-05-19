package com.eggdevs.diamondstreak

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CalendarPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return TOTAL_MONTHS
    }

    override fun createFragment(position: Int): Fragment {
        val yearSelected = DiamondUtils.getYearSelectedFromPosition(position)
        val monthSelected = DiamondUtils.getMonthSelectedFromPosition(position)
        return MonthFragment.newInstance("this is fragment $position", monthSelected, yearSelected)
    }
}