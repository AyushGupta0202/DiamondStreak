package com.eggdevs.diamondstreak.ui.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eggdevs.diamondstreak.TAG
import com.eggdevs.diamondstreak.databinding.LiDayOfMonthBinding
import com.eggdevs.diamondstreak.models.local.CalendarMonthItem

class CalendarMonthAdapter: ListAdapter<CalendarMonthItem, CalendarMonthAdapter.CalendarMonthViewHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarMonthViewHolder {
        val binding = LiDayOfMonthBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CalendarMonthViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarMonthViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class CalendarMonthViewHolder(private val binding: LiDayOfMonthBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(calendarMonthItem: CalendarMonthItem) {
            with(binding) {
                if (calendarMonthItem.isClickable) {
                    root.setOnClickListener {
                        calendarMonthItem.isMarked = !calendarMonthItem.isMarked
                        binding.ivMonthItemBackground.isVisible = calendarMonthItem.isMarked
                        if (calendarMonthItem.isMarked) {
                            tvMonthItem.setTextColor(Color.WHITE)
                        } else {
                            tvMonthItem.setTextColor(Color.BLACK)
                        }
                    }
                }
                tvMonthItem.text = calendarMonthItem.visibleText
                if (calendarMonthItem.isMarked) {
                    tvMonthItem.setTextColor(Color.WHITE)
                } else {
                    tvMonthItem.setTextColor(Color.BLACK)
                }
                ivMonthItemBackground.isVisible = calendarMonthItem.isMarked
            }
        }
    }
}

val diffCallBack = object: DiffUtil.ItemCallback<CalendarMonthItem>() {
    override fun areItemsTheSame(oldItem: CalendarMonthItem, newItem: CalendarMonthItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: CalendarMonthItem,
        newItem: CalendarMonthItem
    ): Boolean {
        return oldItem.date == newItem.date
    }
}