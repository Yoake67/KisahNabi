package com.uti.kisahnabi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_Quiz4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_quiz4)

        // 1. Terima skor dari Activity sebelumnya (Quiz3)
        val skorDariSoal3 = intent.getIntExtra("SKOR_SEMENTARA", 0)

        // Hubungkan view dari layout
        val radioGroupSoal4 = findViewById<RadioGroup>(R.id.radioGroup4)
        val buttonSubmit4 = findViewById<Button>(R.id.submit4)
        val idJawabanBenarSoal4 = R.id.opsiB_soal4_jawaban // Pastikan ID ini benar

        buttonSubmit4.setOnClickListener {
            val idJawabanTerpilih = radioGroupSoal4.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Hitung skor untuk soal ini
                val skorSoalIni = if (idJawabanTerpilih == idJawabanBenarSoal4) 10 else 0

                // 3. Jumlahkan skor dari soal sebelumnya dengan skor soal ini
                val totalSkorSaatIni = skorDariSoal3 + skorSoalIni

                // 4. Intent untuk pindah ke halaman kuis nomor 5, sambil membawa total skor
                val intent = Intent(this, MainActivity_Quiz5::class.java)
                intent.putExtra("SKOR_SEMENTARA", totalSkorSaatIni)
                startActivity(intent)
            }
        }
    }
}