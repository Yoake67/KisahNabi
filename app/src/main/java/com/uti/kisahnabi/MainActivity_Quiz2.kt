package com.uti.kisahnabi // Pastikan nama package ini sesuai dengan proyek Anda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_Quiz2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_quiz2)

        val radioGroupSoal2 = findViewById<RadioGroup>(R.id.radioGroup2)
        val buttonSubmit2 = findViewById<Button>(R.id.submit2)
        val idJawabanBenarSoal2 = R.id.opsiD_soal2_jawaban // Jawaban: Nabi Muhammad SAW

        buttonSubmit2.setOnClickListener {
            val idJawabanTerpilih = radioGroupSoal2.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                if (idJawabanTerpilih == idJawabanBenarSoal2) {
                    Toast.makeText(this, "Jawaban Anda Benar!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Jawaban Anda Salah.", Toast.LENGTH_SHORT).show()
                }

                // Intent mengarah ke soal nomor 3.
                val intent = Intent(this, MainActivity_Quiz3::class.java)
                startActivity(intent)
            }
        }
    }
}
