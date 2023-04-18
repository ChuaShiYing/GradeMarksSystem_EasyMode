package com.example.practicaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spinner: Spinner = findViewById(R.id.course_select)
        spinner.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            this, R.array.courseCode, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val button: Button = findViewById(R.id.grade_button)
        button.setOnClickListener {
            val score: EditText = findViewById(R.id.editScore)

            val result = when {
                score.text.toString().toDouble() >= 80 -> 'A'
                score.text.toString().toDouble() >= 79 -> "A-"
                score.text.toString().toDouble() >= 74 -> "B"
                score.text.toString().toDouble() >= 69 -> "B"
                score.text.toString().toDouble() >= 69 -> "B"
                score.text.toString().toDouble() >= 64 -> "B-"
                score.text.toString().toDouble() >= 59 -> "C+"
                score.text.toString().toDouble() >= 54 -> "C"

                else -> {
                    'D'
                }
            }
            val resultText: TextView = findViewById(R.id.grade_result)
            resultText.text = getString(R.string.gradeResult) + " " + result
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val selection: TextView = findViewById(R.id.course_result)
        selection.text = p0?.getItemAtPosition(p2).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}