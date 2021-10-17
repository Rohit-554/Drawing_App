package com.example.kids_drawing_app

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import com.example.kids_drawing_app.MainActivity.Companion.paintbrush
import com.example.kids_drawing_app.MainActivity.Companion.path
import kotlin.io.path.moveTo

class Drawing_area :View {

    var params : ViewGroup.LayoutParams? = null
    companion object{

        var pathlist = ArrayList<Path>()
        var colorlist = ArrayList<Int>()
        var currentBrush = Color.BLACK
    }

    constructor(context: Context) : this(context, null) {
        init()

    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        init()

    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        paintbrush.isAntiAlias = true
        paintbrush.color = currentBrush
        paintbrush.style = Paint.Style.STROKE
        paintbrush.strokeJoin = Paint.Join.ROUND
        paintbrush.strokeWidth = 8f

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y

        when(event.action){
            MotionEvent.ACTION_DOWN ->{
                path.moveTo(x,y)
                return true
            }
            MotionEvent.ACTION_MOVE ->{
                path.lineTo(x,y)
                pathlist.add(path)
                colorlist.add(currentBrush)
            }
            else -> return false
        }
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas) {
        for(i in pathlist.indices){
            paintbrush.setColor(colorlist[i])
            canvas.drawPath(pathlist[i], paintbrush)
            invalidate()
        }
    }


}


