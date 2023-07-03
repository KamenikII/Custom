package ru.netology.customviews.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import ru.netology.customviews.R
import ru.netology.customviews.util.AndroidUtils
import kotlin.math.min
import kotlin.math.pow
import kotlin.random.Random

class StatsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : View(
    context,
    attrs,
    defStyleAttr,
    defStyleRes
) {
    private fun smartCustom(sum: Float): Float =
        if (sum < 1) 1F else sum.pow(-1)
    private fun generateRandomColor() = Random.nextInt(0xFF000000.toInt(), 0xFFFFFFFF.toInt())

    //данные
    var data: List<Float> = emptyList()
        set(value) {
            field = value
            invalidate()
        }

    //рисуем кружочек
    private var radius = 0F
    private var center = PointF(0F, 0F)
    private var oval = RectF(0F, 0F, 0F, 0F)

    //цвета, ширина линии
    private var lineWidth = AndroidUtils.dp(context, 5F).toFloat()
    private var fontSize = AndroidUtils.dp(context, 40F).toFloat()
    private var colors = emptyList<Int>()

    init {
        context.withStyledAttributes(
            attrs,
            R.styleable.StatsView
        ) {
            lineWidth = getDimension(R.styleable.StatsView_lineWidth, lineWidth)
            fontSize = getDimension(R.styleable.StatsView_fontSize, fontSize)
            val resId = getResourceId(R.styleable.StatsView_colors, 0)
            colors = resources.getIntArray(resId).toList()
        }
    }

    //кисть рисунка
    private val paint = Paint(
        Paint.ANTI_ALIAS_FLAG
    ).apply {
        style = Paint.Style.STROKE
        strokeWidth = lineWidth
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }

    //кисть текста
    private val textPaint = Paint(
        Paint.ANTI_ALIAS_FLAG
    ).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = fontSize
    }

    //изменение размеров
    override fun onSizeChanged(
        w: Int,
        h: Int,
        oldw: Int,
        oldh: Int
    ) {
        radius = min(w, h) / 2F - lineWidth / 2
        center = PointF(w / 2F, h / 2F)
        oval = RectF(
            center.x - radius,
            center.y - radius,
            center.x + radius,
            center.y + radius,
        )
    }

    //рисуем
    override fun onDraw(canvas: Canvas) {
        if (data.isEmpty()) {
            return
        }

        //от куда стартуем
        var startFrom = -90F

        //рисуем процентики в кружочке
        for ((index, datum) in data.withIndex()) {
            val angle = 360F * datum * smartCustom(data.sum())
            paint.color = colors.getOrNull(index) ?: randomColor()
            canvas.drawArc(
                oval,
                startFrom,
                angle,
                false,
                paint)
            startFrom += angle
        }

        //делаем текст
        canvas.drawText(
            "%.2f%%".format(data.sum() * 100 * smartCustom(data.sum())),
            center.x,
            center.y + textPaint.textSize / 4,
            textPaint,
        )

        //для красивск
        val lastDot = 1F
        paint.color = colors.getOrElse(0) { randomColor() }
        canvas.drawArc(oval, startFrom, lastDot, false, paint)

    }

    //рандомные цвета
    private fun randomColor() = Random.nextInt(0xFF000000.toInt(), 0xFFFFFFFF.toInt())
}