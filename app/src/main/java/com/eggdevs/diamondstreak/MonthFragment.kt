package com.eggdevs.diamondstreak

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.eggdevs.diamondstreak.databinding.FragmentMonthBinding
import com.eggdevs.diamondstreak.ui.adapters.CalendarMonthAdapter
import kotlinx.coroutines.launch
import java.util.*

private const val LABEL_ARG = "label_arg"
private const val MONTH_SELECTED = "month_selected"
private const val YEAR_SELECTED = "year_selected"
class MonthFragment : Fragment() {
    private var _binding: FragmentMonthBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel by viewModels<MonthViewModel>()
    private val adapter = CalendarMonthAdapter()

    companion object {
        fun newInstance(arg: String, monthSelected: Int, yearSelected: Int) = MonthFragment().apply {
            arguments = Bundle().apply {
                putString(LABEL_ARG, arg)
                putInt(MONTH_SELECTED, monthSelected)
                putInt(YEAR_SELECTED, yearSelected)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMonthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var monthInt = 0
        var yearInt = 0
        arguments?.apply {
            monthInt = getInt(MONTH_SELECTED)
            yearInt = getInt(YEAR_SELECTED)
            val date = Date(2023 - EPOCH_YEAR, 0, 10)
            val c = Calendar.getInstance()
            c.time = date
            val day = c.get(Calendar.DAY_OF_WEEK)
            binding.tvMonth.text = day.toString()
            binding.tvMonthHeader.text = MONTHS[monthInt]
            binding.tvYearHeader.text = yearInt.toString()
        }
        binding.cv.setOnDateChangeListener(object: CalendarView.OnDateChangeListener {
            override fun onSelectedDayChange(p0: CalendarView, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
            }
        })
        binding.rvCalendarMonth.layoutManager = GridLayoutManager(requireContext(), WEEK_DAYS_COUNT)
        binding.rvCalendarMonth.adapter = adapter
        setObservers(monthInt, yearInt)
    }

    private fun setObservers(monthInt: Int, yearInt: Int) {
        lifecycleScope.launch {
            viewModel.getMonthDaysList(monthInt, yearInt).collect {
                adapter.submitList(it.toList())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}