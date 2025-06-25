package com.uti.kisahnabi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_Quiz7 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Memuat layout untuk soal nomor 7
        setContentView(R.layout.activity_main_quiz7)

        // 1. Terima skor dari Activity sebelumnya (Quiz6)
        val skorDariSoal6 = intent.getIntExtra("SKOR_SEMENTARA", 0)

        // Menghubungkan view dari layout activity_main_quiz7.xml
        val radioGroupSoal7 = findViewById<RadioGroup>(R.id.radioGroup7)
        val buttonSubmit7 = findViewById<Button>(R.id.submit7)
        val idJawabanBenarSoal7 = R.id.opsiB_soal7_jawaban // Jawaban benar adalah Nabi Daud AS

        buttonSubmit7.setOnClickListener {
            val idJawabanTerpilih = radioGroupSoal7.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Hitung skor untuk soal ini
                val skorSoalIni = if (idJawabanTerpilih == idJawabanBenarSoal7) 10 else 0

                // 3. Jumlahkan skor dari soal sebelumnya dengan skor soal ini
                val totalSkorSaatIni = skorDariSoal6 + skorSoalIni

                // 4. Intent untuk pindah ke halaman kuis nomor 8, sambil membawa total skor
                val intent = Intent(this, MainActivity_Quiz8::class.java)
                intent.putExtra("SKOR_SEMENTARA", totalSkorSaatIni)
                startActivity(intent)
            }
        }
    }
}