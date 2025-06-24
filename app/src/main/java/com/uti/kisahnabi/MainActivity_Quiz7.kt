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

        // Menghubungkan view dari layout activity_main_quiz7.xml
        val radioGroupSoal7 = findViewById<RadioGroup>(R.id.radioGroup7)
        val buttonSubmit7 = findViewById<Button>(R.id.submit7)
        val idJawabanBenarSoal7 = R.id.opsiB_soal7_jawaban // Jawaban benar adalah Nabi Daud AS

        buttonSubmit7.setOnClickListener {
            val idJawabanTerpilih = radioGroupSoal7.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Menampilkan Toast berdasarkan jawaban benar atau salah
                if (idJawabanTerpilih == idJawabanBenarSoal7) {
                    Toast.makeText(this, "Jawaban Anda Benar!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Jawaban Anda Salah.", Toast.LENGTH_SHORT).show()
                }

                // Mengarahkan ke soal nomor 8 setelah menjawab
                val intent = Intent(this, MainActivity_Quiz8::class.java)
                startActivity(intent)

                // Tidak ada finish() agar bisa kembali ke soal ini dari soal 8
            }
        }
    }
}
