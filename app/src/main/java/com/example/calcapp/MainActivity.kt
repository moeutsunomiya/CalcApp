package com.example.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v:View){

        val intent = Intent(this, Main2Activity::class.java)

        //editTextの値をString型にキャストする
        val eText1: String = editText1.text.toString();
        val eText2: String = editText2.text.toString();

        //入力値が空文字の場合、注意を促すメッセージを表示する
        if(eText1.equals(" ")  || eText2.equals(" ")){
            showAlertDialog()
        }else {
            //入力値がある場合、計算を行う
            val editText1 = eText1.toDouble()
            val editText2 = eText2.toDouble()

            intent.putExtra("VALUE1", editText1)
            intent.putExtra("VALUE2", editText2)
            if (v.id == R.id.button1) {
                intent.putExtra("OPERATION", 1)
            } else if (v.id == R.id.button2) {
                intent.putExtra("OPERATION", 2)
            } else if (v.id == R.id.button3) {
                intent.putExtra("OPERATION", 3)
            }  else if (v.id == R.id.button4) {
                intent.putExtra("OPERATION", 4)
            }
            startActivity(intent)
        }
    }

    //数値が未入力で四則計算ボタンが押下された場合は、注意を促すメッセージを表示する
    private fun showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("注意")
        alertDialogBuilder.setMessage("数値を入力してください。")

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK"){dialog, which ->
            Log.d("", "肯定ボタン")
        }

        // 中立ボタンに表示される文字列、押したときのリスナーを設定する
        // 使わない引数の場合は「_」と記述するのがkotlinの慣習
        alertDialogBuilder.setNeutralButton(" "){_,_ ->
            Log.d("CalcApp", "中立ボタン")
        }

        // 否定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNegativeButton(" "){_,_ ->
            Log.d("CalcApp", "否定ボタン")
        }
        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}
