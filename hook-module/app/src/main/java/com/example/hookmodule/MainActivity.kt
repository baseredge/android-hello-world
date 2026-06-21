package com.example.hookmodule

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this).apply {
            text = "LSPatch 测试 Hook 模块\n\n此模块会修改 com.example.testapp 的 getMessage() 返回值\n\n使用 LSPatch 将此模块嵌入目标应用即可生效"
            textSize = 16f
            setPadding(32, 32, 32, 32)
        }
        setContentView(textView)
    }
}
