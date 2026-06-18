package com.example.hello

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = TextView(this)
        textView.text = getString(R.string.hello_text)
        textView.textSize = 24f
        textView.setPadding(64, 64, 64, 64)

        setContentView(textView)
    }
}
