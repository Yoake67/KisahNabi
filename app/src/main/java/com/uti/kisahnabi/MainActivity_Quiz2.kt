package com.uti.kisahnabi

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

        // 1. Terima skor yang dikirim dari MainActivity_Quiz (soal 1)
        val skorDariSoal1 = intent.getIntExtra("SKOR_SEMENTARA", 0)

        // Hubungkan view dari layout
        val radioGroupSoal2 = findViewById<RadioGroup>(R.id.radioGroup2)
        val buttonSubmit2 = findViewById<Button>(R.id.submit2)
        val idJawabanBenarSoal2 = R.id.opsiD_soal2_jawaban // Jawaban: Nabi Muhammad SAW

        buttonSubmit2.setOnClickListener {
            val idJawabanTerpilih = radioGroupSoal2.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Hitung skor untuk soal ini
                val skorSoalIni = if (idJawabanTerpilih == idJawabanBenarSoal2) 10 else 0

                // 3. Jumlahkan skor dari soal sebelumnya dengan skor soal ini
                val totalSkorSaatIni = skorDariSoal1 + skorSoalIni

                // 4. Intent mengarah ke soal nomor 3, sambil membawa total skor yang baru
                val intent = Intent(this, MainActivity_Quiz3::class.java)
                intent.putExtra("SKOR_SEMENTARA", totalSkorSaatIni)
                startActivity(intent)
            }
        }
    }
}