package com.example.testapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)

        textView.text = getMessage()

        button.setOnClickListener {
            Toast.makeText(this, getMessage(), Toast.LENGTH_SHORT).show()
        }
    }

    // 这个方法将被 Hook 模块修改
    fun getMessage(): String {
        return "我是原始消息，没有被修改！"
    }
}
