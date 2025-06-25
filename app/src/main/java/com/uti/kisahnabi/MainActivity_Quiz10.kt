package com.uti.kisahnabi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_Quiz10 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Memuat layout untuk soal nomor 10
        setContentView(R.layout.activity_main_quiz10)

        // 1. Terima skor dari Activity sebelumnya (Quiz9)
        val skorDariSoal9 = intent.getIntExtra("SKOR_SEMENTARA", 0)

        // Menghubungkan view dari layout activity_main_quiz10.xml
        val radioGroupSoal10 = findViewById<RadioGroup>(R.id.radioGroup10)
        val buttonSubmit10 = findViewById<Button>(R.id.submit10)
        val idJawabanBenarSoal10 = R.id.opsiB_soal10_jawaban // Jawaban benar adalah Nabi Nuh AS

        buttonSubmit10.setOnClickListener {
            val idJawabanTerpilih = radioGroupSoal10.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Hitung skor untuk soal ini
                val skorSoalIni = if (idJawabanTerpilih == idJawabanBenarSoal10) 10 else 0

                // 3. Jumlahkan skor dari soal sebelumnya dengan skor soal ini untuk mendapatkan skor AKHIR
                val skorAkhirTotal = skorDariSoal9 + skorSoalIni

                // 4. Intent untuk pindah ke halaman hasil akhir
                val intent = Intent(this, MainActivity_Hasil_Quiz::class.java)

                // Kirim skor akhir dengan key "SKOR_AKHIR" agar bisa diterima di HasilQuizActivity
                intent.putExtra("SKOR_AKHIR", skorAkhirTotal)
                startActivity(intent)

                finish()
            }
        }
    }
}
