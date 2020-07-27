package com.MyIntentApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ORANG = "extra_orang"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)


        val tvObject: TextView = findViewById(R.id.tv_object_received)

        val person = intent.getParcelableExtra(EXTRA_ORANG)as Person
        val text  = "Name: ${person.name.toString()}, \nEmail : ${person.email}, \nAge: ${person.age}, \nLocation: ${person.city}"
        tvObject.text = text
    }
}
