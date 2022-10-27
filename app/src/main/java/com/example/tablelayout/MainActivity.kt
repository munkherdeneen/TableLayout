package com.example.tablelayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var map : HashMap<String, String> = HashMap<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_android.setOnClickListener {
            if(android_version.text.isEmpty() || android_code.text.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Version or Name is empty, please fill them out and proceed again",
                    Toast.LENGTH_LONG
                ).show()
            }
            else {
                val newRow = TableRow(applicationContext)
                val params = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
                newRow.layoutParams = params

                val element1 = TextView(this)
                element1.text = android_version.text
                element1.setPadding(0, 0,0, 15)
                element1.setBackgroundColor(Color.parseColor("#ED80DE"))

                val element2 = TextView(this)
                element2.text = android_code.text
                element2.setPadding(0, 0,0, 15)
                element2.setBackgroundColor(Color.parseColor("#ED80DE"))

                newRow.addView(element1)
                newRow.addView(element2)
                newRow.setPadding(0, 0, 0, 15)

                versionsTable.addView(newRow)

                android_version.text.clear()
                android_code.text.clear()

                Toast.makeText(
                    applicationContext,
                    "New version has been added successful",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}