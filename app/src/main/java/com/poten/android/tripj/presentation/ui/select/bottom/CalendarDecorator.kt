package com.poten.android.tripj.presentation.ui.select.bottom

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.poten.android.tripj.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade

class StartEndDecorator(
    context: Context,
    private val startDate: CalendarDay,
    private val endDate: CalendarDay
) : DayViewDecorator {
    private val startEndDrawable =
        ContextCompat.getDrawable(context, R.drawable.selector_calendar_start_end)

    override fun shouldDecorate(day: CalendarDay): Boolean {
        return day == startDate || day == endDate
    }

    override fun decorate(view: DayViewFacade) {
        view.setBackgroundDrawable(startEndDrawable!!)
    }
}

class RangeDecorator(
    context: Context,
    private val startDate: CalendarDay,
    private val endDate: CalendarDay
) : DayViewDecorator {
    private val drawableRange: Drawable =
        ContextCompat.getDrawable(context, R.drawable.background_calendar_range)!!

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return day?.isAfter(startDate) == true && day.isBefore(endDate)
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setSelectionDrawable(drawableRange)
    }
}

class StartEdgeDecorator(
    context: Context,
    private val startDate: CalendarDay
) : DayViewDecorator {
    private val drawable: Drawable =
        ContextCompat.getDrawable(context, R.drawable.background_calendar_start_end)!!

    override fun shouldDecorate(day: CalendarDay): Boolean {
        return day == startDate
    }

    override fun decorate(view: DayViewFacade) {
        view.setBackgroundDrawable(drawable)
    }
}

class EndEdgeDecorator(
    context: Context,
    private val endDate: CalendarDay
) : DayViewDecorator {
    private val drawable: Drawable =
        ContextCompat.getDrawable(context, R.drawable.background_calendar_start_end)!!

    override fun shouldDecorate(day: CalendarDay): Boolean {
        return day == endDate
    }

    override fun decorate(view: DayViewFacade) {
        view.setBackgroundDrawable(drawable)
    }
}