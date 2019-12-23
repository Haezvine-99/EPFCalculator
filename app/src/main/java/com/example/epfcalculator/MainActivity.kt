package com.example.epfcalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtDOB.setOnClickListener(){
            val c:Calendar = Calendar.getInstance();
            val currentDay = c.get(Calendar.DAY_OF_MONTH);
            val currentMonth = c.get(Calendar.MONTH);
            val currentYear = c.get(Calendar.YEAR);

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener() {
                    view, year, month, day -> txtDOB.setText(day.toString() + "/" + (month + 1).toString() + "/" + year.toString())
                val age = currentYear - year
                val savings:Double = minSavings(age)
                val invest:Double = savings * 0.3

                txtAge.text = age.toString()
                txtMinSavings.text = savings.toString()
                txtAL.text = invest.toString()
            }, currentYear, currentMonth, currentDay)
//..........
            dpd.show()
        }

    }
    fun minSavings (age:Int) : Double{
        when (age) {
            in 16..20 -> return 5000.00
            in 21..25 -> return 14000.00
            in 26..30 -> return 29000.00
            in 31..35 -> return 50000.00
            in 36..40 -> return 78000.00
            in 41..45 -> return 116000.00
            in 46..50 -> return 165000.00
            in 51..55 -> return 228000.00
            else -> return 0.00
        }
    }
}
