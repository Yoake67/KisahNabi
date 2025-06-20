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

        // 1. Ambil referensi komponen dari layout XML
        val radioGroupSoal3 = findViewById<RadioGroup>(R.id.radioGroup3)
        val buttonSubmit3 = findViewById<Button>(R.id.submit3)

        // 2. ID dari RadioButton yang merupakan jawaban benar untuk soal nomor 3
        // Jawaban: Nabi Sulaiman AS
        val idJawabanBenarSoal3 = R.id.opsiA_soal3_jawaban

        // 3. Atur aksi ketika tombol SUBMIT diklik
        buttonSubmit3.setOnClickListener {
            // Dapatkan ID dari RadioButton yang sedang dipilih
            val idJawabanTerpilih = radioGroupSoal3.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                // Jika belum ada yang dipilih, tampilkan pesan
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Jika sudah ada yang dipilih, tampilkan pesan benar/salah
                if (idJawabanTerpilih == idJawabanBenarSoal3) {
                    Toast.makeText(this, "Jawaban Anda Benar!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Jawaban Anda Salah.", Toast.LENGTH_SHORT).show()
                }

                //  Intent untuk pindah ke halaman kuis nomor 4
                val intent = Intent(this, MainActivity_Quiz4::class.java)
                startActivity(intent)
            }
        }
    }
}