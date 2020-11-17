package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.widget.EditText

class TestDemoEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatEditText(context, attrs) {

    val strokePaint = TextPaint()

    init {
        background = null
        setTextColor(Color.BLACK)
        setPadding(20, 20, 20, 20)
        //初始化具有描边的文字画笔
        strokePaint.apply {
            set(paint)
            strokeWidth = 10f
            color = Color.RED
            strokeJoin = Paint.Join.ROUND
            style = Paint.Style.FILL_AND_STROKE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        //绘制描边文字
        val staticLayout = StaticLayout(
            text,
            strokePaint,
            layout.width,
            layout.alignment,
            layout.spacingMultiplier,
            layout.spacingAdd,
            true
        )
        //Canvas 平移到 EditText 绘制文字的起点
        val offsetX = paddingLeft.toFloat()
        val offsetY = baseline + paint.fontMetrics.top
        canvas?.apply {
            save()
            translate(offsetX, offsetY)
            staticLayout.draw(canvas)
            restore()
        }
        super.onDraw(canvas)
    }
}