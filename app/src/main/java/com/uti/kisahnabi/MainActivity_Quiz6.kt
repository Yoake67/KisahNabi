package com.uti.kisahnabi // Pastikan package name ini sesuai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_Quiz6 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Memuat layout untuk soal nomor 6
        setContentView(R.layout.activity_main_quiz6)

        // Menghubungkan view dari layout activity_main_quiz6.xml
        val radioGroupSoal6 = findViewById<RadioGroup>(R.id.radioGroup6)
        val buttonSubmit6 = findViewById<Button>(R.id.submit6)
        val idJawabanBenarSoal6 = R.id.opsiB_soal6_jawaban // Jawaban benar adalah Nabi Musa AS

        buttonSubmit6.setOnClickListener {
            val idJawabanTerpilih = radioGroupSoal6.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Menampilkan Toast berdasarkan jawaban benar atau salah
                if (idJawabanTerpilih == idJawabanBenarSoal6) {
                    Toast.makeText(this, "Jawaban Anda Benar!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Jawaban Anda Salah.", Toast.LENGTH_SHORT).show()
                }

                // --- BAGIAN YANG DIUBAH ---
                // Mengarahkan ke soal nomor 7 setelah menjawab
                val intent = Intent(this, MainActivity_Quiz7::class.java)
                startActivity(intent)
                // Baris finish() tidak ditambahkan agar bisa kembali ke soal ini
            }
        }
    }
}