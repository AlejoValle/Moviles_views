package com.example.views

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var simpleList: ListView? = null
    var optionsList = arrayOf("General", "Visualizacion de mapa", "Avisos", "Area")
    var flags = intArrayOf(
        R.drawable.settings,
        R.drawable.map,
        R.drawable.warning,
        R.drawable.location,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        setContentView(R.layout.activity_main)
        simpleList = findViewById<View>(R.id.simpleListView) as ListView
        val arrayAdapter =
            ArrayAdapter<String>(this, R.layout.activity_content_main, R.id.textView, optionsList)
        simpleList!!.adapter = arrayAdapter
    }
}