package com.example.calculatorappmidterm

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1:EditText = findViewById(R.id.num1)
        val num2:EditText = findViewById(R.id.num2)
        val cal: Button = findViewById(R.id.Calculate)
        val result: TextView = findViewById(R.id.result)
        val spinner: Spinner = findViewById(R.id.spinner)
        var flag:String = "Sum"
        var options = arrayOf("Sum","Subtraction","Multiply","Division")

        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        cal.setOnClickListener{
            val x:Int = num1.text.toString().toInt()
            val y: Int = num2.text.toString().toInt()

            when(flag) {
                "Sum" -> {
                    result.text = sum(x,y).toString()
                }
                "Subtraction" -> {
                    result.text = subtract(x,y).toString()
                }
                "Multiply" -> {
                    result.text = multiply(x,y).toString()
                }
                "Division" ->  {
                    result.text = divide(x,y).toString()
                }
                else -> {
                    Toast.makeText(this,"None",Toast.LENGTH_SHORT).show()
                }
            }
        }

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // You can leave this empty if there's no action on nothing selected
            }
        }
    }

    private fun sum(x:Int,y:Int) :Int {
        return x+y
    }

    private fun subtract(x:Int,y:Int) :Int {
        return x-y
    }

    private fun multiply(x:Int,y:Int) :Int {
        return x*y
    }

    private fun divide(x:Int,y:Int) :Int {
        return x/y
    }
}
