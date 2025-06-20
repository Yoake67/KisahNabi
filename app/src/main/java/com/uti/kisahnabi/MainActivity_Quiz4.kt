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

        val radioGroupSoal4 = findViewById<RadioGroup>(R.id.radioGroup4)
        val buttonSubmit4 = findViewById<Button>(R.id.submit4)
        val idJawabanBenarSoal4 = R.id.opsiB_soal4_jawaban // Nabi Ibrahim AS

        buttonSubmit4.setOnClickListener {
            val idJawabanTerpilih = radioGroupSoal4.checkedRadioButtonId

            if (idJawabanTerpilih == -1) {
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                if (idJawabanTerpilih == idJawabanBenarSoal4) {
                    Toast.makeText(this, "Jawaban Anda Benar!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Jawaban Anda Salah.", Toast.LENGTH_SHORT).show()
                }

                // --- BAGIAN YANG DIUBAH ---
                // Mengarahkan ke soal nomor 5
                val intent = Intent(this, MainActivity_Quiz5::class.java)
                startActivity(intent)
            }
        }
    }
}
