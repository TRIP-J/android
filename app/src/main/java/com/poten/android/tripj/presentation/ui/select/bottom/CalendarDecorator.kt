package com.poten.android.tripj.presentation.ui.select.bottom

import android.content.Context
import android.graphics.Paint
import androidx.core.content.ContextCompat
import com.poten.android.tripj.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade

class CalendarDecorator(
    private val context: Context,
    private val startDay: CalendarDay,
    private val endDay:CalendarDay,
) : DayViewDecorator {

    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val cylinderPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val radius: Float = 16f
    private val strokeWidth: Float = 4f


    init {
        circlePaint.style = Paint.Style.FILL
        circlePaint.color = ContextCompat.getColor(context,R.color.sky_blue_500)
        cylinderPaint.style = Paint.Style.STROKE
        cylinderPaint.color = ContextCompat.getColor(context,R.color.sky_blue_500)
        cylinderPaint.strokeWidth = strokeWidth

    }


    override fun shouldDecorate(day: CalendarDay): Boolean {
        return true
    }

    override fun decorate(view: DayViewFacade) {
        view.setBackgroundDrawable(
            ContextCompat.getDrawable(
                context,
                R.drawable.drawable_calendar_selector
            )!!
        )
    }
}