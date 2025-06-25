package com.uti.kisahnabi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_Quiz3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Mengatur layout dari file activity_main_quiz3.xml
        setContentView(R.layout.activity_main_quiz3)

        // 1. Terima skor dari Activity sebelumnya (Quiz2)
        val skorDariSoal2 = intent.getIntExtra("SKOR_SEMENTARA", 0)

        // Ambil referensi komponen dari layout XML
        val radioGroupSoal3 = findViewById<RadioGroup>(R.id.radioGroup3)
        val buttonSubmit3 = findViewById<Button>(R.id.submit3)

        // ID dari RadioButton yang merupakan jawaban benar untuk soal nomor 3
        // Jawaban: Nabi Sulaiman AS
        val idJawabanBenarSoal3 = R.id.opsiA_soal3_jawaban

        // Atur aksi ketika tombol SUBMIT diklik
        buttonSubmit3.setOnClickListener {
            // Dapatkan ID dari RadioButton yang sedang dipilih
            val idJawabanTerpilih = radioGroupSoal3.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                // Jika belum ada yang dipilih, tampilkan pesan
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // 2. Hitung skor untuk soal ini (20 poin jika benar, 0 jika salah)
                val skorSoalIni = if (idJawabanTerpilih == idJawabanBenarSoal3) 10 else 0

                // 3. Jumlahkan skor dari soal sebelumnya dengan skor soal ini
                val totalSkorSaatIni = skorDariSoal2 + skorSoalIni

                // 4. Intent untuk pindah ke halaman kuis nomor 4, sambil membawa total skor
                val intent = Intent(this, MainActivity_Quiz4::class.java)
                intent.putExtra("SKOR_SEMENTARA", totalSkorSaatIni)
                startActivity(intent)
            }
        }
    }
}
