package com.alfan.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var editWidth: EditText
    private lateinit var editHeight: EditText
    private lateinit var editLength: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var tvResult: TextView


    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT) as String
            tvResult.text = result
        }

        editWidth = findViewById(R.id.edit_width)
        editHeight = findViewById(R.id.edit_height)
        editLength = findViewById(R.id.edit_length)
        buttonCalculate = findViewById(R.id.button_calculate)
        tvResult = findViewById(R.id.tv_result)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_calculate){
            val inputLength = editLength.text.toString().trim()
            val inputWidth = editWidth.text.toString().trim()
            val inputHeight = editHeight.text.toString().trim()

            var isEmpty = false

            if(inputLength.isEmpty()){
                isEmpty = true
                editLength.error = "Kolom ini tidak boleh kosong"
            }

            if(inputWidth.isEmpty()){
                isEmpty = true
                editWidth.error = "Kolom ini tidak boleh kosong"
            }
            if(inputHeight.isEmpty()){
                isEmpty = true
                editHeight.error = "Kolom ini tidak boleh kosong"
            }

            if(!isEmpty){
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }

        }
    }
}
