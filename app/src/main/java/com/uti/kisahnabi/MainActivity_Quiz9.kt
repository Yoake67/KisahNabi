package com.uti.kisahnabi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_Quiz9 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Memuat layout untuk soal nomor 9
        setContentView(R.layout.activity_main_quiz9)

        // 1. Terima skor dari Activity sebelumnya (Quiz8)
        val skorDariSoal8 = intent.getIntExtra("SKOR_SEMENTARA", 0)

        // Menghubungkan view dari layout activity_main_quiz9.xml
        val radioGroupSoal9 = findViewById<RadioGroup>(R.id.radioGroup9)
        val buttonSubmit9 = findViewById<Button>(R.id.submit9)
        val idJawabanBenarSoal9 = R.id.opsiC_soal9_jawaban // Jawaban benar adalah Nabi Muhammad SAW

        buttonSubmit9.setOnClickListener {
            val idJawabanTerpilih = radioGroupSoal9.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Hitung skor untuk soal ini
                val skorSoalIni = if (idJawabanTerpilih == idJawabanBenarSoal9) 10 else 0

                // 3. Jumlahkan skor dari soal sebelumnya dengan skor soal ini
                val totalSkorSaatIni = skorDariSoal8 + skorSoalIni

                // 4. Intent untuk pindah ke halaman kuis nomor 10, sambil membawa total skor
                val intent = Intent(this, MainActivity_Quiz10::class.java)
                intent.putExtra("SKOR_SEMENTARA", totalSkorSaatIni)
                startActivity(intent)
            }
        }
    }
}