package com.MyIntentApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var buttonChoose: Button
    private lateinit var rgNumber: RadioGroup

    companion object{
        const val EXTRA_MILIH_NILAI = "extra_milih_nilai"
        const val HASIL_CODE = 120
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        buttonChoose = findViewById(R.id.button_choose)
        rgNumber = findViewById(R.id.rg_number)

        buttonChoose.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_choose){
            if (rgNumber.checkedRadioButtonId !=0){
                var nilai = 0
                when(rgNumber.checkedRadioButtonId){
                    R.id.rb_50 -> nilai = 50
                    R.id.rb_100 -> nilai = 100
                    R.id.rb_150 -> nilai = 150
                    R.id.rb_200 -> nilai = 200
                }

                var hasilIntent = Intent()
                hasilIntent.putExtra(EXTRA_MILIH_NILAI, nilai)
                setResult(HASIL_CODE, hasilIntent)
                finish()
            }
        }
    }
}
