package com.example.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import java.lang.NullPointerException

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val value1 = intent.getDoubleExtra("VALUE1", 0.0)
        val value2 = intent.getDoubleExtra("VALUE2", 0.0)
        val operation = intent.getIntExtra("OPERATION", 0)

        //四則計算のボタンごとに、処理を分岐する
        if (operation == 1) {
            textView.text = "${value1 + value2}"
        } else if (operation == 2) {
            textView.text = "${value1 - value2}"
        } else if (operation == 3) {
            textView.text = "${value1 * value2}"
        } else if (operation == 4) {
            textView.text = "${value1 / value2}"
        }
    }
}
