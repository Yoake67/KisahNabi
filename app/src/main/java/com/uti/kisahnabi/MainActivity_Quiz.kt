package com.uti.kisahnabi

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity_Quiz : AppCompatActivity() {
    private lateinit var radioNabiMusa: RadioButton
    private lateinit var radioNabiIbrahim: RadioButton
    private lateinit var radioNabiAdam: RadioButton
    private lateinit var radioNabiMuhammad: RadioButton
    private lateinit var submitButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        radioNabiMusa = findViewById(R.id.Nabi_Musa)
        radioNabiIbrahim = findViewById(R.id.Nabi_Ibrahim)
        radioNabiAdam = findViewById(R.id.Nabi_Adam)
        radioNabiMuhammad = findViewById(R.id.Nabi_Muhammad)
        submitButton = findViewById(R.id.submit1)
        resultText = findViewById(R.id.Soal1)

        submitButton.setOnClickListener {
            val isMusa = radioNabiMusa.isChecked
            val isIbrahim = radioNabiIbrahim.isChecked
            val isAdam = radioNabiAdam.isChecked
            val isMuhammad = radioNabiMuhammad.isChecked

            if (!isMusa && !isIbrahim && !isAdam && !isMuhammad) {
                // No option selected
                resultText.text = "Harap pilih jawaban terlebih dahulu."
                return@setOnClickListener
            }

            if (isAdam) {
                resultText.text = "Jawaban benar!"
            } else {
                resultText.text = "Jawaban salah, coba lagi."
            }
            // Disable radio buttons to prevent answer change after submit
            radioNabiMusa.isEnabled = false
            radioNabiIbrahim.isEnabled = false
            radioNabiAdam.isEnabled = false
            radioNabiMuhammad.isEnabled = false
            // Disable submit button to prevent multiple submits
            submitButton.isEnabled = false
        }
    }
}

