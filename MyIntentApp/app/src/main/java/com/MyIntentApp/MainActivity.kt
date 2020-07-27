package com.MyIntentApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithActivityData:Button = findViewById(R.id.btn_activity_data)
        btnMoveWithActivityData.setOnClickListener(this)
    }

    override fun onClick(v: View) {
       when(v.id){
           R.id.btn_move_activity ->{
            val pindahIntent = Intent(this@MainActivity, MoveActivity::class.java)
               startActivity(pindahIntent)
           }

           R.id.btn_activity_data ->{
            val moveWithDataIntent = Intent(this@MainActivity, MoveWithActivityData::class.java)
               moveWithDataIntent.putExtra(MoveWithActivityData.EXTRA_NAME, "M. Alfan")
               moveWithDataIntent.putExtra(MoveWithActivityData.EXTRA_AGE, 20)
               startActivity(moveWithDataIntent)
           }
       }
    }
}
