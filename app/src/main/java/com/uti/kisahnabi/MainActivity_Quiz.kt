package com.uti.kisahnabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity_Quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // --- MULAI LOGIKA KUIS DARI SINI ---

        // 1. Ambil referensi komponen dari layout XML
        val radioGroupSoal1 = findViewById<RadioGroup>(R.id.radioGroup1)
        val buttonSubmit1 = findViewById<Button>(R.id.submit1)

        // ID dari RadioButton yang merupakan jawaban benar
        val idJawabanBenar = R.id.Nabi_Ibrahim1

        // 2. Atur aksi ketika tombol SUBMIT diklik
        buttonSubmit1.setOnClickListener {
            // Dapatkan ID dari RadioButton yang sedang dipilih oleh pengguna
            val idJawabanTerpilih = radioGroupSoal1.checkedRadioButtonId

            // 3. Periksa apakah pengguna sudah memilih jawaban atau belum
            if (idJawabanTerpilih == -1) {
                // Jika belum ada yang dipilih, tampilkan pesan peringatan
                Toast.makeText(this, "Silakan pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                // Jika sudah ada yang dipilih, tetap lanjutkan.
                // Pertama, tampilkan apakah jawaban benar atau salah.
                if (idJawabanTerpilih == idJawabanBenar) {
                    // Jawaban BENAR
                    Toast.makeText(this, "Jawaban Anda Benar!", Toast.LENGTH_SHORT).show()
                } else {
                    // Jawaban SALAH
                    Toast.makeText(this, "Jawaban Anda Salah.", Toast.LENGTH_SHORT).show()
                }

                // Kemudian, selalu pindah ke halaman kuis berikutnya
                val intent = Intent(this, MainActivity_Quiz2::class.java)
                startActivity(intent)
            }
        }
    }
}


