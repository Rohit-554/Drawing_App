package com.example.kids_drawing_app

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.kids_drawing_app.Drawing_area.Companion.colorlist
import com.example.kids_drawing_app.Drawing_area.Companion.pathlist


class MainActivity : AppCompatActivity() {

    companion object{
        var path = Path()
        var paintbrush = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val Red_Button = findViewById<ImageButton>(R.id.RedButton)
        val Blue_Button = findViewById<ImageButton>(R.id.BlueButton)
        val Black_Button = findViewById<ImageButton>(R.id.BlackButton)
        val Eraser = findViewById<ImageButton>(R.id.Eraser)

        Red_Button.setOnClickListener {
            Toast.makeText(this, "RED", Toast.LENGTH_SHORT).show()
            paintbrush.color = Color.RED
            currentcolor(paintbrush.color)
        }
        Blue_Button.setOnClickListener {
            Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show()
            paintbrush.color = Color.BLUE
            currentcolor(paintbrush.color)
        }
        Black_Button.setOnClickListener {
            Toast.makeText(this, "Black", Toast.LENGTH_SHORT).show()
            paintbrush.color = Color.BLACK
            currentcolor(paintbrush.color)
        }
        Eraser.setOnClickListener {
            Toast.makeText(this, "RED", Toast.LENGTH_SHORT).show()
            pathlist.clear()
            colorlist.clear()
            path.reset()

        }

    }

    private fun currentcolor(color: Int){
        Drawing_area.currentBrush =color
        path = Path()
    }
}