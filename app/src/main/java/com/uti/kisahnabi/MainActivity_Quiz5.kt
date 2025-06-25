package com.uti.kisahnabi

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

        // 1. Terima skor dari Activity sebelumnya (Quiz4)
        val skorDariSoal4 = intent.getIntExtra("SKOR_SEMENTARA", 0)

        // Menggunakan ID view yang benar dari activity_main_quiz5.xml
        val radioGroupSoal5 = findViewById<RadioGroup>(R.id.radioGroup5)
        val buttonSubmit5 = findViewById<Button>(R.id.submit5)
        val idJawabanBenarSoal5 = R.id.opsiA_soal5_jawaban // Jawaban benar adalah Nabi Ayyub AS

        buttonSubmit5.setOnClickListener {
            val idJawabanTerpilih = radioGroupSoal5.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Hitung skor untuk soal ini
                val skorSoalIni = if (idJawabanTerpilih == idJawabanBenarSoal5) 10 else 0

                // 3. Jumlahkan skor dari soal sebelumnya dengan skor soal ini
                val totalSkorSaatIni = skorDariSoal4 + skorSoalIni

                // 4. Intent untuk pindah ke halaman kuis nomor 6, sambil membawa total skor
                val intent = Intent(this, MainActivity_Quiz6::class.java)
                intent.putExtra("SKOR_SEMENTARA", totalSkorSaatIni)
                startActivity(intent)
            }
        }
    }
}