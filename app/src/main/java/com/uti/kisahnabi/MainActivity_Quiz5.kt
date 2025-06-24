package com.uti.kisahnabi // Pastikan package name ini sesuai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_Quiz5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Memuat layout yang benar untuk soal nomor 5
        setContentView(R.layout.activity_main_quiz5)

        // Menggunakan ID view yang benar dari activity_main_quiz5.xml
        val radioGroupSoal5 = findViewById<RadioGroup>(R.id.radioGroup5)
        val buttonSubmit5 = findViewById<Button>(R.id.submit5)
        val idJawabanBenarSoal5 = R.id.opsiA_soal5_jawaban // Jawaban benar adalah Nabi Ayyub AS

        buttonSubmit5.setOnClickListener {
            val idJawabanTerpilih = radioGroupSoal5.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Menampilkan Toast berdasarkan jawaban benar atau salah
                if (idJawabanTerpilih == idJawabanBenarSoal5) {
                    Toast.makeText(this, "Jawaban Anda Benar!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Jawaban Anda Salah.", Toast.LENGTH_SHORT).show()
                }

                // Mengarahkan ke soal nomor 6 setelah menjawab
                val intent = Intent(this, MainActivity_Quiz6::class.java)
                startActivity(intent)
            }
        }
    }
}