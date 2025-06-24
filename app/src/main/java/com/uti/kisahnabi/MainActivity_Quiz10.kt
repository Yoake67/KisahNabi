package com.uti.kisahnabi // Pastikan package name ini sesuai

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

        // Menghubungkan view dari layout activity_main_quiz10.xml
        val radioGroupSoal10 = findViewById<RadioGroup>(R.id.radioGroup10)
        val buttonSubmit10 = findViewById<Button>(R.id.submit10)
        val idJawabanBenarSoal10 = R.id.opsiB_soal10_jawaban // Jawaban benar adalah Nabi Nuh AS

        buttonSubmit10.setOnClickListener {
            val idJawabanTerpilih = radioGroupSoal10.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Menampilkan Toast berdasarkan jawaban benar atau salah
                if (idJawabanTerpilih == idJawabanBenarSoal10) {
                    Toast.makeText(this, "Jawaban Anda Benar!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Jawaban Anda Salah.", Toast.LENGTH_SHORT).show()
                }

                // Menampilkan pesan bahwa kuis telah selesai
                Toast.makeText(this, "Selamat, Anda telah menyelesaikan kuis!", Toast.LENGTH_LONG).show()

                // Menonaktifkan tombol setelah kuis selesai
                buttonSubmit10.isEnabled = false

                // Di sini Anda bisa menambahkan logika untuk pindah ke halaman utama atau halaman skor
                // setelah beberapa detik, atau biarkan pengguna menekan tombol kembali.
            }
        }
    }
}
