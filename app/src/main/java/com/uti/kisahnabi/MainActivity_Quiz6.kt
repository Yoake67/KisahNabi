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

        // 1. Terima skor dari Activity sebelumnya (Quiz5)
        val skorDariSoal5 = intent.getIntExtra("SKOR_SEMENTARA", 0)

        // Menghubungkan view dari layout activity_main_quiz6.xml
        val radioGroupSoal6 = findViewById<RadioGroup>(R.id.radioGroup6)
        val buttonSubmit6 = findViewById<Button>(R.id.submit6)
        val idJawabanBenarSoal6 = R.id.opsiB_soal6_jawaban // Jawaban benar adalah Nabi Musa AS

        buttonSubmit6.setOnClickListener {
            val idJawabanTerpilih = radioGroupSoal6.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Hitung skor untuk soal ini
                val skorSoalIni = if (idJawabanTerpilih == idJawabanBenarSoal6) 10 else 0

                // 3. Jumlahkan skor dari soal sebelumnya dengan skor soal ini
                val totalSkorSaatIni = skorDariSoal5 + skorSoalIni

                // 4. Intent untuk pindah ke halaman kuis nomor 7, sambil membawa total skor
                val intent = Intent(this, MainActivity_Quiz7::class.java)
                intent.putExtra("SKOR_SEMENTARA", totalSkorSaatIni)
                startActivity(intent)
            }
        }
    }
}