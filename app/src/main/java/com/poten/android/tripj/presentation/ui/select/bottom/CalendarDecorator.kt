package com.poten.android.tripj.presentation.ui.select.bottom

import android.graphics.Paint
import com.poten.android.tripj.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.spans.DotSpan

class CalendarDecorator(private val startDay: CalendarDay,
    private val endDay: CalendarDay,
    private val mainColor : Int,
    private val subColor: Int,
    ) : DayViewDecorator {

    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val cylinderPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val radius : Float=16f
    private val strokeWidth: Float=4f

    init {
        circlePaint.style=Paint.Style.FILL
        circlePaint.color= mainColor
        cylinderPaint.style=Paint.Style.STROKE
        cylinderPaint.color=subColor
        cylinderPaint.strokeWidth=strokeWidth
    }


    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return false
    }

    override fun decorate(view: DayViewFacade?) {
        view?.addSpan(DotSpan(radius,mainColor))
    }

}